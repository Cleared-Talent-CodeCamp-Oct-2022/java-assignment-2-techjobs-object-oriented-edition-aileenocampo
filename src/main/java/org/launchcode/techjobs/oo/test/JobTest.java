package org.launchcode.techjobs.oo.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.launchcode.techjobs.oo.*;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.*;

/**
 * Created by LaunchCode
 */
@RunWith(JUnit4.class)
public class JobTest {
    @Test
    public void testSettingJobId() {
        Job jobOne = new Job();
        Job jobTwo = new Job();

        assertNotEquals(jobOne, jobTwo);
    }

    @Test
    public void testJobConstructorSetsAllFields() {
        Job job = new Job("Product tester", new Employer("ACME"), new Location("Desert"),
                new PositionType("Quality control"), new CoreCompetency("Persistence"));

        assertTrue(job.getId() > 0);
        assertEquals("Product tester", job.getName());
        assertEquals("ACME", job.getEmployer().toString());
        assertEquals("Desert", job.getLocation().toString());
        assertEquals("Quality control", job.getPositionType().toString());
        assertEquals("Persistence", job.getCoreCompetency().toString());
    }

    @Test
    public void testJobsForEquality() {
        Job jobOne = new Job("Product tester", new Employer("ACME"), new Location("Desert"),
                new PositionType("Quality control"), new CoreCompetency("Persistence"));
        Job jobTwo = new Job("Product tester", new Employer("ACME"), new Location("Desert"),
                new PositionType("Quality control"), new CoreCompetency("Persistence"));

        assertFalse(jobOne.equals(jobTwo));
    }

    @Test
    public void testToStringStartsAndEndsWithNewLine() {
        Job job = new Job("Product tester", new Employer("ACME"), new Location("Desert"),
                new PositionType("Quality control"), new CoreCompetency("Persistence"));

        int length = job.toString().length();

        assertEquals(job.toString().charAt(0), '\n');
        assertEquals(job.toString().charAt(length-1), '\n');
    }

    @Test
    public void testToStringContainsCorrectLabelsAndData() {
        Job job = new Job("Product tester", new Employer("ACME"), new Location("Desert"),
                new PositionType("Quality control"), new CoreCompetency("Persistence"));

        assertTrue(job.toString().contains("ID:"));
        assertTrue(job.toString().contains("Name: Product tester"));
        assertTrue(job.toString().contains("Employer: ACME"));
        assertTrue(job.toString().contains("Location: Desert"));
        assertTrue(job.toString().contains("Position Type: Quality control"));
        assertTrue(job.toString().contains("Core Competency: Persistence"));
    }

    public void testToStringHandlesEmptyField() {
        Job job = new Job("Product tester", null, null,
                new PositionType("Quality control"), new CoreCompetency("Persistence"));

        assertTrue(job.toString().contains("ID:"));
        assertTrue(job.toString().contains("Name: Data not available"));
        assertTrue(job.toString().contains("Employer: Data not available"));
        assertTrue(job.toString().contains("Location: Data not available"));
        assertTrue(job.toString().contains("Position Type: Quality control"));
        assertTrue(job.toString().contains("Core Competency: Persistence"));
    }

}
