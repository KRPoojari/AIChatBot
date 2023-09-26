import React, { useState } from "react";
import Form from "./Components/Chatbot/Form";
import Form1 from "./Components/Chatbot/Form1";
function App() {
  // Use state to keep track of the selected form
  const [selectedForm, setSelectedForm] = useState("Form");

  // Function to handle radio button selection
  const handleRadioChange = (event) => {
    setSelectedForm(event.target.value);
  };

  return (
    <div className="App">
      <h1>Choose mode to chat!!:</h1>
      {/* Radio buttons for form selection */}
      <label>
        <input
          type="radio"
          value="Form"
          checked={selectedForm === "Form"}
          onChange={handleRadioChange}
        />
        Chat
      </label>
      <label>
        <input
          type="radio"
          value="Form1"
          checked={selectedForm === "Form1"}
          onChange={handleRadioChange}
        />
        Voice Chat
      </label>

      {/* Render the selected form based on the state */}
      {selectedForm === "Form" ? <Form /> : <Form1 />}
    </div>
  );
}

//  Form() {
//   return <div><Form /> </div>;
// }

// function Form1() {
//   return <div><Form1 /></div>;
// }

export default App;
