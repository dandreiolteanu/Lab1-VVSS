package Lab1MV;

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
import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.categories.Category;

import static org.junit.Assert.assertTrue;

@Category(IntegrationTests.class)
public class IntegrationTests {

    private StudentValidator vs;
    private TemaLabValidator vt;
    private NotaValidator vn;
    private StudentXMLRepo strepo;
    private TemaLabXMLRepo tmrepo;
    private NotaXMLRepo ntrepo;
    private StudentXMLService stsrv;
    private TemaLabXMLService tmsrv;
    private NotaXMLService ntsrv;


    @Before
    public void setData() {
        vs = new StudentValidator();
        vt= new TemaLabValidator();
        vn = new NotaValidator();
        strepo = new StudentXMLRepo(vs,"StudentiXML.xml");
        tmrepo = new TemaLabXMLRepo(vt,"TemaLaboratorXML.xml");
        ntrepo = new NotaXMLRepo(vn,"NotaXML.xml");
        stsrv = new StudentXMLService(strepo);
        tmsrv = new TemaLabXMLService(tmrepo);
        ntsrv = new NotaXMLService(ntrepo);
    }

    @Test
    public void addStudentTest() {

        Integer studentCountBeforeAdd = stsrv.getSize();

        String id,nume,grupa,email,prof;

        id= "9991";
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

    @Test
    public void addHomeworkTest() {

        Integer temeBefore = tmsrv.getSize();

        String id,descr,saptLim,saptPred;
        id = "9990";
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

    @Test(expected = NullPointerException.class)
    public void addNotaTest() {
        ntsrv.depunctare(tmsrv, "9990", "1");
        assertTrue(true);
    }

    @Test
    public void testAll() {
        addStudentTest();
        addHomeworkTest();
        addNotaTest();
    }
}
