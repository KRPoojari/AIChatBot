import React from 'react';
import { render, screen } from '@testing-library/react';
import FAQs from './FAQs';
import '@testing-library/jest-dom/extend-expect';

test('renders FAQs component', () => {
  render(<FAQs />);
  
  const titleElement = screen.getByText(/Telstra FAQ's/i);
  expect(titleElement).toBeInTheDocument();
  
  
  const questions = [
    "How can I download payslips?",
    "How do I increase my voluntary provident fund contribution?",
    "How can we download the applications blocked in our laptops",
    "Where should we apply for leave?",
    "Do Telstra have any website to learn about certain projects?",
    "How can i claim my reimbursement?",
  ];

  questions.forEach((question) => {
    const questionElement = screen.getByText(question);
    expect(questionElement).toBeInTheDocument();
  });
});
