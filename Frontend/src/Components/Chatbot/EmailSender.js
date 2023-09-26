import React, {useState} from "react";
function EmailSender(props){
  const [recipientEmail, setRecipientEmail] = useState('');
  const [response, setResponse] = useState('');

  const sendEmail = async () => {
    try {
      const transcriptTxt = new Blob([props.myObj.em], { type: 'text/plain' });
      console.log(transcriptTxt);
      const formData = new FormData();
      formData.append('remail', recipientEmail);
      formData.append('file', transcriptTxt, 'transcript.txt');

      const response = await fetch("http://localhost:8081/sendTranscriptEmail", {
        method: 'POST',
        body: formData,
       
      });

      if (response.ok) {
        setResponse('Email sent successfully.');
      } else {
        setResponse('Email sending failed.');
      }
    } catch (error) {
      console.error('Error:', error);
      setResponse('An error occurred.');
    }
  };

  return (
    <div>
      <h2>Email Sender</h2>
      <form>
        <div>
          <label htmlFor="recipientEmail">Recipient Email:</label>
          <input
            type="email"
            id="recipientEmail"
            value={recipientEmail}
            onChange={(e) => setRecipientEmail(e.target.value)}
            required
          />
        </div>
        <button type="button" onClick={sendEmail}>
          Send Email
        </button>
      </form>
      {response && <div>{response}</div>}
    </div>
  );
}
export default EmailSender;