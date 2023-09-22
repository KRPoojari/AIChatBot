import React, { Component } from 'react';
import ChatBot from 'react-simple-chatbot';


class YourChatbot extends Component {
  constructor(props) {
    super(props);
    this.state = {
      inputMode: 'text', // Default to text input
      conversation: [], // To store the conversation
      isRecording: false, // To track recording state
      recordedChunks: [], // To store recorded audio chunks
    };
    this.mediaRecorder = null; // MediaRecorder instance
  }

  componentDidMount() {
    // Initialize MediaRecorder when the component mounts
    navigator.mediaDevices.getUserMedia({ audio: true }).then((stream) => {
      this.mediaRecorder = new MediaRecorder(stream);

      // Listen for dataavailable event when recording starts
      this.mediaRecorder.ondataavailable = (e) => {
        if (e.data.size > 0) {
          this.setState((prevState) => ({
            recordedChunks: [...prevState.recordedChunks, e.data],
          }));
        }
      };

      // Listen for stop event when recording stops
      this.mediaRecorder.onstop = () => {
        const audioBlob = new Blob(this.state.recordedChunks, { type: 'audio/wav' });
        const audioUrl = URL.createObjectURL(audioBlob);

        // Here, you can save or upload the audio recording as needed
        console.log('Recording URL:', audioUrl);

        // Reset recording state and recorded chunks
        this.setState({
          isRecording: false,
          recordedChunks: [],
        });
      };
    });
  }

  startRecording = () => {
    if (!this.state.isRecording) {
      this.setState({ isRecording: true });
      this.mediaRecorder.start();
    }
  };

  stopRecording = () => {
    if (this.state.isRecording) {
      this.mediaRecorder.stop();
    }
  };

  // Other chatbot-related functions (handleUserMessage, handleBotResponse, etc.) go here...

  render() {
    const { inputMode, isRecording } = this.state;

    return (
      <div>
        <div>
          <button onClick={this.handleTextInput}>Text Mode</button>
          <button onClick={this.handleVoiceInput}>Voice Mode</button>
          <button onClick={this.startRecording}>Start Recording</button>
          <button onClick={this.stopRecording}>Stop Recording</button>
        </div>
        <ChatBot
          // ... Chatbot configuration ...
        />
      </div>
    );
  }
}

export default YourChatbot;
