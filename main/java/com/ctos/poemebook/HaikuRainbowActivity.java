package com.ctos.poemebook;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.widget.NestedScrollView;

import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.speech.tts.TextToSpeech;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.BackgroundColorSpan;
import android.widget.TextView;

import java.util.Locale;

import de.hdodenhof.circleimageview.CircleImageView;

public class HaikuRainbowActivity extends AppCompatActivity {
    CircleImageView circleImageView;
    TextView textView;
    TextToSpeech textToSpeech;
    boolean isSpeaking = false;
    Handler handler = new Handler();
    String[] segments; // Array to hold segments
    int currentSegment = 0;
    NestedScrollView nestedScrollView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.haiku_rainbow_activity);

        textToSpeech = new TextToSpeech(getApplicationContext(), status -> {
            if (status != TextToSpeech.ERROR) {
                textToSpeech.setLanguage(Locale.US);
            }
        });
        nestedScrollView = findViewById(R.id.nestedScrollView);
        textView = findViewById(R.id.rainbow);
        segments = textView.getText().toString().split("\n"); // Split poem by lines

        circleImageView = findViewById(R.id.button);
        circleImageView.setOnClickListener(v -> {
            if (!isSpeaking) {
                highlightAndSpeak();
            } else {
                textToSpeech.stop();
                handler.removeCallbacksAndMessages(null); // Cancel scheduled highlights
                resetHighlight(); // Reset text highlighting
                isSpeaking = false;
            }
        });
    }

    private void highlightAndSpeak() {
        if (currentSegment < segments.length) {
            String segment = segments[currentSegment];
            textToSpeech.speak(segment, TextToSpeech.QUEUE_FLUSH, null, null);

            highlightText(currentSegment);
            // Estimate duration or use a fixed delay, adjust as necessary
            long duration = 200 + (long) (segment.length() * 60L); // Example estimation
            handler.postDelayed(this::highlightAndSpeak, duration);

            currentSegment++;
            isSpeaking = true;
        } else {
            // Once we've reached the end, reset the highlighting and stop speaking.
            resetHighlight();
            currentSegment = 0; // Reset the segment index for the next time the button is pressed.
            isSpeaking = false;
        }
    }

    private void highlightText(int segmentIndex) {
        // Reset highlights
        SpannableString resetSpannable = new SpannableString(textView.getText().toString());
        textView.setText(resetSpannable);

        // Find the start and end points of the current segment
        String fullText = textView.getText().toString();
        int start = fullText.indexOf(segments[segmentIndex]);
        int end = start + segments[segmentIndex].length();

        // Apply the highlight to only the current segment
        SpannableString spannableString = new SpannableString(textView.getText());
        spannableString.setSpan(new BackgroundColorSpan(Color.parseColor("#db3c30")), start, end, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);

        textView.setText(spannableString);

        // Adjusted scrolling logic
        textView.post(() -> {
            // Calculate the pixel position of the start and end of the highlighted segment
            int lineStart = textView.getLayout().getLineForOffset(start);
            int lineEnd = textView.getLayout().getLineForOffset(end);
            int pixelStart = textView.getLayout().getLineTop(lineStart);
            int pixelEnd = textView.getLayout().getLineBottom(lineEnd);

            // Get the visible area of the scrollView
            int scrollY = nestedScrollView.getScrollY();
            int height = nestedScrollView.getHeight();
            int scrollViewBottom = scrollY + height;

            // Convert pixel positions to scroll positions by adding the current scroll position
            pixelStart += scrollY;
            pixelEnd += scrollY;

            if (pixelEnd > scrollViewBottom) {
                // Scroll to make the end of the highlighted text visible, if needed
                int scrollTo = nestedScrollView.getScrollY() + (pixelEnd - scrollViewBottom);
                nestedScrollView.smoothScrollTo(0, scrollTo);
            } else if (pixelStart < scrollY) {
                // Optionally, if the start of the highlighted text is above the visible area, scroll up to it
                nestedScrollView.smoothScrollTo(0, pixelStart);
            }
        });
    }


    private void resetHighlight() {
        // Resets the entire text without highlights by creating a new SpannableString without any spans
        SpannableString spannableString = new SpannableString(String.join("\n", segments));
        textView.setText(spannableString);
    }

    @Override
    public void onPause() {
        if (textToSpeech != null) {
            textToSpeech.stop();
            handler.removeCallbacksAndMessages(null);
        }
        super.onPause();
    }

    @Override
    protected void onDestroy() {
        if (textToSpeech != null) {
            textToSpeech.shutdown();
        }
        super.onDestroy();
    }
}