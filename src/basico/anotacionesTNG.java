package basico;

import org.testng.annotations.*;

public class anotacionesTNG {

    @BeforeSuite
    public void beforeSuite(){
        System.out.println("Metodo iniciando el Before beforeSuite");
    }

    @AfterSuite
    public void afterSuite(){
        System.out.println("Metodo iniciando el After afterSuite");
    }

    @BeforeTest
    public void beforeTest(){
        System.out.println("Metodo iniciando el Before beforeTest");
    }

    @AfterTest
    public void afterTest(){
        System.out.println("Metodo iniciando el After afterTest");
    }

    @BeforeGroups
    public void beforeGroups(){
        System.out.println("Metodo iniciando el Before beforeGroups");
    }

    @AfterGroups
    public void afterGroups(){
        System.out.println("Metodo iniciando el After afterGroups");
    }

    @BeforeClass
    public void beforeClass(){
        System.out.println("Metodo iniciando el Before beforeClass");
    }

    @AfterClass
    public void afterClass(){
        System.out.println("Metodo iniciando el After afterClass");
    }

    @BeforeMethod
    public void beforeMethod(){
        System.out.println("Metodo iniciando el Before beforeMethod");
    }

    @AfterMethod
    public void afterMethod(){
        System.out.println("Metodo iniciando el After afterMethod");
    }

    @Test
    public void test1(){
        System.out.println("Metodo iniciando el Before test1");
    }

    @Test
    public void test2(){
        System.out.println("Metodo iniciando el After test2");
    }
}
