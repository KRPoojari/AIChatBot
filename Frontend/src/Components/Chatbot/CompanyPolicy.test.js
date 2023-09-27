import React from 'react';
import { render, screen } from '@testing-library/react';
import '@testing-library/jest-dom/extend-expect'; 
import CompanyPolicy from './CompanyPolicy';

test('renders Telstra Unily Website link', () => {
  render(<CompanyPolicy />);
  const linkElement = screen.getByText(/Telstra Unily Website/i);
  expect(linkElement).toBeInTheDocument();
});

test('renders Ask HR link', () => {
  render(<CompanyPolicy />);
  const linkElement = screen.getByText(/Ask HR/i);
  expect(linkElement).toBeInTheDocument();
});

test('renders Confluence link', () => {
  render(<CompanyPolicy />);
  const linkElement = screen.getByText(/Confluence/i);
  expect(linkElement).toBeInTheDocument();
});

test('renders Company Policies link', () => {
  render(<CompanyPolicy />);
  const linkElement = screen.getByText(/Company's Policies/i);
  expect(linkElement).toBeInTheDocument();
});

test('renders Workday link', () => {
  render(<CompanyPolicy />);
  const linkElement = screen.getByText(/Workday/i);
  expect(linkElement).toBeInTheDocument();
});

test('renders Jira link', () => {
  render(<CompanyPolicy />);
  const linkElement = screen.getByText(/Jira/i);
  expect(linkElement).toBeInTheDocument();
});
