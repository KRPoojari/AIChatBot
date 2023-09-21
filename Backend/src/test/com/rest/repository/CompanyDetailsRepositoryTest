package com.rest.repository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.rest.entity.CompanyDetails;
import com.rest.service.CompanyDetailsService;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;



public class CompanyDetailsRepositoryTest {

    @Mock
    private CompanyDetailsRepository companyDetailsRepository;

    @InjectMocks
    private CompanyDetailsService companyDetailsService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testSearchByFileName() {
       
        String fileName = "sample_file.txt";
        CompanyDetails sampleCompanyDetails = new CompanyDetails();
        sampleCompanyDetails.setFile_name(fileName);
        when(companyDetailsRepository.searchByFileName(fileName)).thenReturn(sampleCompanyDetails);
        CompanyDetails retrievedCompanyDetails = companyDetailsRepository.searchByFileName(fileName);
        verify(companyDetailsRepository, times(1)).searchByFileName(fileName);
        assertEquals(sampleCompanyDetails, retrievedCompanyDetails);
    }
}
