import React, { useState } from 'react';

const OnboardingProgress = () => {
  const [progress, setProgress] = useState(0);
  const [questions, setQuestions] = useState([
    {
      id: 1,
      question: 'Have you attended the induction program?',
      answer: null, // Use null to represent no choice made
    },
    {
      id: 2,
      question: 'Did you apply for the ID card?',
      answer: null,
    },
    {
      id: 3,
      question: 'Have you received Telstra Goodies?',
      answer: null,
    },
    {
      id: 4,
      question: 'Did the chapter heads connect with you?',
      answer: null,
    },
  ]);

  const handleAnswerChange = (id, choice) => {
    const updatedQuestions = questions.map((q) =>
      q.id === id ? { ...q, answer: choice } : q
    );
    setQuestions(updatedQuestions);
    calculateProgress(updatedQuestions);
  };

  const calculateProgress = (updatedQuestions) => {
    const answeredQuestions = updatedQuestions.filter((q) => q.answer === 'yes');
    const newProgress = (answeredQuestions.length / updatedQuestions.length) * 100;
    setProgress(newProgress);
  };

  return (
    <div className="onboarding-progress">
      <h2>Onboarding Progress</h2>
      <p>{`${progress}% complete`}</p>
      <div className="question-list">
        {questions.map((question) => (
          <div key={question.id} className="question">
            <p>{question.question}</p>
            <label>
              Yes
              <input
                type="radio"
                name={`question-${question.id}`}
                value="yes"
                checked={question.answer === 'yes'}
                onChange={() => handleAnswerChange(question.id, 'yes')}
              />
            </label>
            <label>
              No
              <input
                type="radio"
                name={`question-${question.id}`}
                value="no"
                checked={question.answer === 'no'}
                onChange={() => handleAnswerChange(question.id, 'no')}
              />
            </label>
          </div>
        ))}
      </div>
    </div>
  );
};

export default OnboardingProgress;
