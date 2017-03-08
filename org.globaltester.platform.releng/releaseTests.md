Releasetests GlobalTester Platform
=====================
This document describes validation tests that shall be performed on the final product artifacts immediately before publishing. These tests focus on overall product quality and completeness (e.g. inclusion/integration of required features). For a complete test coverage please also refer to tests defined in the according bundles.

1. [ ] __Run GlobalTester Platform Product__
Launch the GlobalTester Platform product and check the following
 - [ ] the executable has the GT icon
 - [ ] the GT splash screen is shown on startup
 - [ ] the GT welcome page is correctly formatted
 - [ ] check the existence of the buttons for test script execution ("Run Test" and "Run tests with configuration selection") and campaign execution ("Create TestCampaign" and "Create TestCampaign and execute it")
 - [ ] check hover text of the before mentioned buttons
 - [ ] the GlobalTester perspective is correct
 - [ ] GlobalTester Platform feature is shown in the installation details
 - [ ] version numbers are correct
 - [ ] check that list of used Open Source components is up-to-date and also available via GUI
 - [ ] check for GUI matching secunet corporate design guide lines
 - [ ] create a new project (GlobalTester --> TestSpecification) and run the available demo test; check for warning informing about missing execution engine

1. [ ] __Install and Run GlobalTester Platform Feature__ 
Launch a fresh Eclipse and do/check the following
 - [ ] install product from UpdateSite (accept unsigned Content, restart required)
 - [ ] check successful installation
     - [ ] GlobalTesterPlatform feature is shown in the installation details
     - [ ] version numbers are correct
 - [ ] import all integrated script projects from bundle and check that all user relevant files are visible

1. [ ] __Check general test report and log file behavior__ 
     - [ ] open large log file, i.e. file Size >> 10 MB
     - [ ] generate test report for a test suite
     - [ ] generate test report for a single test case
     
1. [ ] __Check SampleConfig dialog__
     - [ ] open "Select SampleConfig" dialog and press "Cancel"

1. [ ] __Check Test Campaign execution__ 
     - [ ] create and execute test campaign, then prepare to re-execute test campaign with explicit selection of SampleConfig, change SampleConfig, continue with execution and check that changes do not influence prior test campaign executions
     - [ ] open log file from test campaign
     - [ ] change some value in test campaign but do not save, then generate report and check for unsaved changes warning
     - [ ] create and execute test campaign, restart GT and remove test campaign via GT-Navigator

1. [ ] __Check generation of test report from test campaign execution__
     - [ ] check that test report PDF is a valid PDF file
     - [ ] check consistency of file integrity check results in test report matches log file
     - [ ] check for plausible execution time data for test cases in test report
     - [ ] check that test report is consistent with test report created by executing test directly
     - [ ] check that the report directory created by generating a test report contains log files as expected
     - [ ] select option "Add separate log files for each test case" and check that the report directory created by generating a test report contains log files as expected

<p style="page-break-after: always"/>
