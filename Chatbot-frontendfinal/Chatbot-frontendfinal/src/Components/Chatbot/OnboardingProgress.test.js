import React from 'react';
import { render, fireEvent, screen } from '@testing-library/react';
import OnboardingProgress from './OnboardingProgress';

test('renders the component with initial state', () => {
  render(<OnboardingProgress />);
  
  // Check if the initial progress is 0%
  expect(screen.getByText('0% complete')).toBeInTheDocument();

  // Check if all questions are present
  expect(screen.getByText('Have you attended the induction program?')).toBeInTheDocument();
  expect(screen.getByText('Did you apply for the ID card?')).toBeInTheDocument();
  expect(screen.getByText('Have you received Telstra Goodies?')).toBeInTheDocument();
  expect(screen.getByText('Did the chapter heads connect with you?')).toBeInTheDocument();

  // Check if placeholder text is present in input fields
  const inputFields = screen.getAllByPlaceholderText('Yes or No');
  expect(inputFields).toHaveLength(4);
});

test('updates progress when "Yes" is selected', () => {
  render(<OnboardingProgress />);

  // Set the "Yes" option for the first question
  fireEvent.click(screen.getByLabelText('Yes', { selector: 'input[type="radio"]' }));

  // Check if the progress has been updated to 25%
  expect(screen.getByText('25% complete')).toBeInTheDocument();
});

test('does not update progress when "No" is selected', () => {
  render(<OnboardingProgress />);

  // Set the "No" option for the first question
  fireEvent.click(screen.getByLabelText('No', { selector: 'input[type="radio"]' }));

  // Check if the progress remains 0%
  expect(screen.getByText('0% complete')).toBeInTheDocument();
});
