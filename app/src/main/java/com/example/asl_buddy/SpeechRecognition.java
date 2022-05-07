package com.example.asl_buddy;

import com.microsoft.cognitiveservices.speech.*;
import com.microsoft.cognitiveservices.speech.audio.AudioConfig;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

public class SpeechRecognition {
    private String key = "0a8b5330e2b54a41b5d542ac802451f9";
    private String serviceRegion = "eastus";

    public String initialize(String[] args) throws InterruptedException, ExecutionException {
        SpeechConfig speechConfig = SpeechConfig.fromSubscription(key, serviceRegion);
        speechConfig.setSpeechRecognitionLanguage("en-US");
        return recognizeFromMicrophone(speechConfig);
    }

    public String recognizeFromMicrophone(SpeechConfig speechConfig) throws InterruptedException, ExecutionException {
        //To recognize speech from an audio file, use `fromWavFileInput` instead of `fromDefaultMicrophoneInput`:
        //AudioConfig audioConfig = AudioConfig.fromWavFileInput("YourAudioFile.wav");
        AudioConfig audioConfig = AudioConfig.fromDefaultMicrophoneInput();
        SpeechRecognizer speechRecognizer = new SpeechRecognizer(speechConfig, audioConfig);

        System.out.println("Listening...");
        Future<SpeechRecognitionResult> task = speechRecognizer.recognizeOnceAsync();
        SpeechRecognitionResult speechRecognitionResult = task.get();

        if (speechRecognitionResult.getReason() == ResultReason.RecognizedSpeech) {
            System.out.println("RECOGNIZED: Text=" + speechRecognitionResult.getText());
            return speechRecognitionResult.getText();
        }
        else if (speechRecognitionResult.getReason() == ResultReason.NoMatch) {
            System.out.println("NOMATCH: Speech could not be recognized.");
            return "Speech could not be recognized.";
        }
        else if (speechRecognitionResult.getReason() == ResultReason.Canceled) {
            CancellationDetails cancellation = CancellationDetails.fromResult(speechRecognitionResult);

            System.out.println("CANCELED: Reason=" + cancellation.getReason());

            if (cancellation.getReason() == CancellationReason.Error) {
                System.out.println("CANCELED: ErrorCode=" + cancellation.getErrorCode());
                System.out.println("CANCELED: ErrorDetails=" + cancellation.getErrorDetails());
                System.out.println("CANCELED: Did you set the speech resource key and region values?");
            }
            return "Error: Microphone permissions may not be allowed.";
        }

        return "An error occurred";
    }
}