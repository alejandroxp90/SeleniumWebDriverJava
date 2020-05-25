package ejercicios;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestEmployeeDetails {
    EmployeeDetails EmD = new EmployeeDetails();
    EmpBusinessLogic EbL = new EmpBusinessLogic();

    @Test//
    public void testCalculador(){
        EmD.setName("Alex");
        EmD.setEdad(36);
        EmD.setSalarioMensual(8000);
        double Expectedcal = EbL.calcularSalarioAnual(EmD);
        Assert.assertEquals(500,Expectedcal,0.0,"500");
    }

    @Test
    public void testCalculador2(){
        EmD.setName("Ady");
        EmD.setEdad(38);
        EmD.setSalarioMensual(8000);
        double Expectedcal = EbL.calcularSalarioAnual(EmD);
        Assert.assertEquals(96000,Expectedcal,0.0,"500");
    }


}
