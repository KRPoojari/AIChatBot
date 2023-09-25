import React from 'react';
import { render, fireEvent, screen } from '@testing-library/react';
import OnboardingProgress from './OnboardingProgress';
import '@testing-library/jest-dom/extend-expect';

describe('OnboardingProgress Component', () => {
  it('renders the component', () => {
    render(<OnboardingProgress />);
    const heading = screen.getByText('Onboarding Progress');
    expect(heading).toBeInTheDocument();
  });

  it('initial progress is 0%', () => {
    render(<OnboardingProgress />);
    const progressText = screen.getByText('0% complete');
    expect(progressText).toBeInTheDocument();
  });

  test('updates progress when "Yes" is selected for the first question', () => {
    render(<OnboardingProgress />);
    
    const progressText = screen.getByText(/0% complete/i);
    expect(progressText).toBeInTheDocument();
    
    fireEvent.click(screen.getByLabelText('Yes', { selector: 'input[type="radio"][name="question-1"]' }));

    expect(progressText).toHaveTextContent(/25% complete/i);
  });
  });
