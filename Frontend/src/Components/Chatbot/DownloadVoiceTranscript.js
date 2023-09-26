import React, { Component } from 'react';

class TextToSpeech extends Component {
  constructor(props) {
    super(props);
    this.state = {
      audioBlob: null,
    };
  }

  convertTextToSpeech = () => {
    const textToConvert = this.props.myObj.em;
    const synthesis = window.speechSynthesis;
    const utterance = new SpeechSynthesisUtterance(textToConvert);

    utterance.onend = () => {
      // Convert the speech to a downloadable MP3 file
      this.convertToBlob(utterance);
    };

    synthesis.speak(utterance);
  };

  convertToBlob = (utterance) => {
    const audioBlob = new Blob([utterance.audioBuffer], { type: 'audio/mpeg' });
    this.setState({ audioBlob });
  };

  render() {
   // const { audioBlob } = this.state;

    return (
      <div>
        <button type="button" onClick={this.convertTextToSpeech}>
          Click here to listen to the recording 
        </button>
        {/* {audioBlob && (
          <div>
            <a
              href={URL.createObjectURL(audioBlob)}
              download="Transcript.mp3"
            >
              Download Audio
            </a>
          </div>
        )} */}
      </div>
    );
  }
}

export default TextToSpeech;
