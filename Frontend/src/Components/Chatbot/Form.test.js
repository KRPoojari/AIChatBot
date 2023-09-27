import React from 'react';
import { render, fireEvent, waitFor } from '@testing-library/react';
import '@testing-library/jest-dom/extend-expect';
import Form from './Form';

describe('Form Component Tests', () => {
  it('Renders the Form component', () => {
    const { getByText } = render(<Form />);
    const header = getByText('Telstra ChatBot');
    expect(header).toBeInTheDocument();
  });

 
});

