package com.rest.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.rest.entity.CompanyDetails;
import com.rest.repository.CompanyDetailsRepository;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;

public class CompanyDetailsServiceTest {

    @Mock
    private CompanyDetailsRepository companyDetailsRepository;

    @InjectMocks
    private CompanyDetailsService companyDetailsService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testSaveData() {
       
        CompanyDetails companyDetails = new CompanyDetails();
        when(companyDetailsRepository.save(companyDetails)).thenReturn(companyDetails);
        CompanyDetails savedCompanyDetails = companyDetailsService.saveData(companyDetails);
        verify(companyDetailsRepository, times(1)).save(companyDetails);
        assertEquals(companyDetails, savedCompanyDetails);
    }

    @Test
    public void testGetAllData() {
       
        List<CompanyDetails> companyDetailsList = new ArrayList<>();
        CompanyDetails companyDetails1 = new CompanyDetails();
        when(companyDetailsRepository.findAll()).thenReturn(companyDetailsList);
        List<CompanyDetails> retrievedCompanyDetailsList = companyDetailsService.getAllData();
        verify(companyDetailsRepository, times(1)).findAll();
        assertEquals(companyDetailsList, retrievedCompanyDetailsList);
    }

    @Test
    public void testDeleteById() {
       
        Integer companyId = 1;
        companyDetailsService.deleteById(companyId);
        verify(companyDetailsRepository, times(1)).deleteById(companyId);
    }
}
