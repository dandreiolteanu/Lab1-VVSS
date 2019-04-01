package Lab1MV;

import static org.junit.Assert.assertTrue;

import Domain.Student;
import Exceptions.ValidatorException;
import Repository.XMLFileRepository.NotaXMLRepo;
import Repository.XMLFileRepository.StudentXMLRepo;
import Repository.XMLFileRepository.TemaLabXMLRepo;
import Service.XMLFileService.NotaXMLService;
import Service.XMLFileService.StudentXMLService;
import Service.XMLFileService.TemaLabXMLService;
import Validator.NotaValidator;
import Validator.StudentValidator;
import Validator.TemaLabValidator;
import org.junit.Test;

import java.rmi.UnexpectedException;
import java.util.Scanner;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue()
    {
        assertTrue( true );
    }

    @Test
    public void studentNameTest() {
        Student s = new Student("123","Andrei",935,"a.olteanu198@icloud.com","Profesor");
        String name = s.getNume();
        assertTrue(name == "Andrei");
    }

    @Test
    public void addStudentTest() {

        StudentValidator vs=new StudentValidator();
        TemaLabValidator vt=new TemaLabValidator();
        NotaValidator vn=new NotaValidator();
        StudentXMLRepo strepo=new StudentXMLRepo(vs,"StudentiXML.xml");
        TemaLabXMLRepo tmrepo=new TemaLabXMLRepo(vt,"TemaLaboratorXML.xml");
        NotaXMLRepo ntrepo=new NotaXMLRepo(vn,"NotaXML.xml");
        StudentXMLService stsrv=new StudentXMLService(strepo);

        Integer studentCountBeforeAdd = stsrv.getSize();

        String id,nume,grupa,email,prof;

        id= "999";
        nume = "AndreiAlex";
        grupa = "935";
        email = "andreiAlex@gmail.com";
        prof = "Profesor";

        Integer newStudentsCount = 0;

        String[] params={id,nume,grupa,email,prof};
        try{
            stsrv.add(params);
            newStudentsCount = stsrv.getSize();
        }catch (ValidatorException ex){
            assertTrue(false);
        }

        assertTrue(studentCountBeforeAdd < newStudentsCount);
    }

    @Test(expected = NullPointerException.class)
    public void addStudentWithNullEmailTest() {
        StudentValidator vs=new StudentValidator();
        TemaLabValidator vt=new TemaLabValidator();
        NotaValidator vn=new NotaValidator();
        StudentXMLRepo strepo=new StudentXMLRepo(vs,"StudentiXML.xml");
        TemaLabXMLRepo tmrepo=new TemaLabXMLRepo(vt,"TemaLaboratorXML.xml");
        NotaXMLRepo ntrepo=new NotaXMLRepo(vn,"NotaXML.xml");
        StudentXMLService stsrv=new StudentXMLService(strepo);

        Integer studentCountBeforeAdd = stsrv.getSize();

        String nume,grupa,prof;

        nume = "AndreiAlex";
        grupa = "935";
        prof = "Profesor";

        Integer newStudentsCount = 0;

        String[] params= {"98213",nume,grupa,null,prof};
        try{
            stsrv.add(params);
            newStudentsCount = stsrv.getSize();
        }catch (ValidatorException ex){
            assertTrue(false);
        }

        assertTrue(studentCountBeforeAdd < newStudentsCount);
    }

    @Test(expected = AssertionError.class)
    public void addStudentWithEmptyEmailTest() {
        StudentValidator vs=new StudentValidator();
        TemaLabValidator vt=new TemaLabValidator();
        NotaValidator vn=new NotaValidator();
        StudentXMLRepo strepo=new StudentXMLRepo(vs,"StudentiXML.xml");
        TemaLabXMLRepo tmrepo=new TemaLabXMLRepo(vt,"TemaLaboratorXML.xml");
        NotaXMLRepo ntrepo=new NotaXMLRepo(vn,"NotaXML.xml");
        StudentXMLService stsrv=new StudentXMLService(strepo);

        Integer studentCountBeforeAdd = stsrv.getSize();

        String nume,grupa,email,prof;

        nume = "AndreiAlex";
        grupa = "935";
        prof = "Profesor";

        Integer newStudentsCount = 0;

        String[] params= {"12312",nume,grupa,"",prof};
        try{
            stsrv.add(params);
            newStudentsCount = stsrv.getSize();
        }catch (ValidatorException ex){
            assertTrue(false);
        }

        assertTrue(studentCountBeforeAdd < newStudentsCount);
    }



    @Test
    public void addHomeworkTest() {

        StudentValidator vs=new StudentValidator();
        TemaLabValidator vt=new TemaLabValidator();
        NotaValidator vn=new NotaValidator();
        StudentXMLRepo strepo=new StudentXMLRepo(vs,"StudentiXML.xml");
        TemaLabXMLRepo tmrepo=new TemaLabXMLRepo(vt,"TemaLaboratorXML.xml");
        NotaXMLRepo ntrepo=new NotaXMLRepo(vn,"NotaXML.xml");
        StudentXMLService stsrv=new StudentXMLService(strepo);

        TemaLabXMLService tmsrv = new TemaLabXMLService(tmrepo);

        Integer temeBefore = tmsrv.getSize();

        String id,descr,saptLim,saptPred;
        id = "999";
        descr = "alabala";
        saptLim = "12";
        saptPred = "12";

        Integer newCount = 0;

        String[] params={id,descr,saptLim,saptPred};
        try{
            tmsrv.add(params);
            newCount = tmsrv.getSize();
        }catch (ValidatorException ex){
            assertTrue(false);
        }


        assertTrue(temeBefore < newCount);
    }

    @Test(expected = NumberFormatException.class)
    public void addHomeworkWithEmptyIDTest() {
        StudentValidator vs=new StudentValidator();
        TemaLabValidator vt=new TemaLabValidator();
        NotaValidator vn=new NotaValidator();
        StudentXMLRepo strepo=new StudentXMLRepo(vs,"StudentiXML.xml");
        TemaLabXMLRepo tmrepo=new TemaLabXMLRepo(vt,"TemaLaboratorXML.xml");
        NotaXMLRepo ntrepo=new NotaXMLRepo(vn,"NotaXML.xml");
        StudentXMLService stsrv=new StudentXMLService(strepo);

        TemaLabXMLService tmsrv = new TemaLabXMLService(tmrepo);


        String descr,saptLim,saptPred;
        descr = "alabala";
        saptLim = "12";
        saptPred = "12";

        Integer newCount = 0;

        String[] params={"", descr,saptLim,saptPred};
        try{
            tmsrv.add(params);
            assertTrue(true);
        }catch (ValidatorException ex){
            assertTrue(false);
        }
    }

    @Test(expected = NullPointerException.class)
    public void addStudentWithNullIDTest() {
        StudentValidator vs=new StudentValidator();
        TemaLabValidator vt=new TemaLabValidator();
        NotaValidator vn=new NotaValidator();
        StudentXMLRepo strepo=new StudentXMLRepo(vs,"StudentiXML.xml");
        TemaLabXMLRepo tmrepo=new TemaLabXMLRepo(vt,"TemaLaboratorXML.xml");
        NotaXMLRepo ntrepo=new NotaXMLRepo(vn,"NotaXML.xml");
        StudentXMLService stsrv=new StudentXMLService(strepo);

        Integer studentCountBeforeAdd = stsrv.getSize();

        String nume,grupa,email,prof;

        nume = "AndreiAlex";
        grupa = "935";
        email = "andreiAlex@gmail.com";
        prof = "Profesor";

        Integer newStudentsCount = 0;

        String[] params= {null,nume,grupa,email,prof};
        try{
            stsrv.add(params);
            newStudentsCount = stsrv.getSize();
        }catch (ValidatorException ex){
            assertTrue(false);
        }

        assertTrue(studentCountBeforeAdd < newStudentsCount);
    }

    @Test(expected = NumberFormatException.class)
    public void addHomeworkWithNullIDTest() {
        StudentValidator vs=new StudentValidator();
        TemaLabValidator vt=new TemaLabValidator();
        NotaValidator vn=new NotaValidator();
        StudentXMLRepo strepo=new StudentXMLRepo(vs,"StudentiXML.xml");
        TemaLabXMLRepo tmrepo=new TemaLabXMLRepo(vt,"TemaLaboratorXML.xml");
        NotaXMLRepo ntrepo=new NotaXMLRepo(vn,"NotaXML.xml");
        StudentXMLService stsrv=new StudentXMLService(strepo);

        TemaLabXMLService tmsrv = new TemaLabXMLService(tmrepo);


        String descr,saptLim,saptPred;
        descr = "alabala";
        saptLim = "12";
        saptPred = "12";

        String[] params={"", descr,saptLim,saptPred};
        try{
            tmsrv.add(params);
            assertTrue(true);
        }catch (ValidatorException ex){
            assertTrue(false);
        }
    }

    @Test(expected = AssertionError.class)
    public void addStudentWithEmptyIDTest() {
        StudentValidator vs=new StudentValidator();
        StudentXMLRepo strepo=new StudentXMLRepo(vs,"StudentiXML.xml");
        StudentXMLService stsrv=new StudentXMLService(strepo);

        Integer studentCountBeforeAdd = stsrv.getSize();

        String nume,grupa,email,prof;

        nume = "AndreiAlex";
        grupa = "935";
        email = "andreiAlex@gmail.com";
        prof = "Profesor";

        Integer newStudentsCount = 0;

        String[] params= {"",nume,grupa,email,prof};
        try{
            stsrv.add(params);
            newStudentsCount = stsrv.getSize();
        }catch (ValidatorException ex){
            assertTrue(false);
        }

        assertTrue(studentCountBeforeAdd < newStudentsCount);
    }

    @Test(expected = AssertionError.class)
    public void addStudentWithEmptyNameTest() {
        StudentValidator vs=new StudentValidator();
        StudentXMLRepo strepo=new StudentXMLRepo(vs,"StudentiXML.xml");
        StudentXMLService stsrv=new StudentXMLService(strepo);

        Integer studentCountBeforeAdd = stsrv.getSize();

        String id, nume,grupa,email,prof;

        id = "9999";
        nume = "";
        grupa = "935";
        email = "andreiAlex@gmail.com";
        prof = "Profesor";

        Integer newStudentsCount = 0;

        String[] params= {id,nume,grupa,email,prof};
        try{
            stsrv.add(params);
            newStudentsCount = stsrv.getSize();
        }catch (ValidatorException ex){
            assertTrue(false);
        }

        assertTrue(studentCountBeforeAdd < newStudentsCount);
    }

    @Test(expected = NullPointerException.class)
    public void addStudentWithNullNameTest() {
        StudentValidator vs=new StudentValidator();
        StudentXMLRepo strepo=new StudentXMLRepo(vs,"StudentiXML.xml");
        StudentXMLService stsrv=new StudentXMLService(strepo);

        Integer studentCountBeforeAdd = stsrv.getSize();

        String id,grupa,email,prof;

        id = "9991";
        grupa = "935";
        email = "andreiAlex@gmail.com";
        prof = "Profesor";

        Integer newStudentsCount = 0;

        String[] params= {id,null,grupa,email,prof};
        try{
            stsrv.add(params);
            newStudentsCount = stsrv.getSize();
        }catch (ValidatorException ex){
            assertTrue(false);
        }

        assertTrue(studentCountBeforeAdd < newStudentsCount);
    }
}
