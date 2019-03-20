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
    public void shouldTestStudentName() {
        Student s = new Student("123","Andrei",935,"a.olteanu198@icloud.com","Profesor");
        String name = s.getNume();
        assertTrue(name == "Andrei");
    }

    @Test
    public void shouldTestAddStudent() {

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
}
