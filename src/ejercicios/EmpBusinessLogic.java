package ejercicios;

public class EmpBusinessLogic {

    public double calcularSalarioAnual(EmployeeDetails employeeDetails){

        double salarioAnual = 0;
        salarioAnual = employeeDetails.getSalarioMensual() * 12;
        System.out.println(salarioAnual);
        return salarioAnual;

    }

    public double calcularEvaluacion(EmployeeDetails employeeDetails){
        double calcEval = 0;
        if (employeeDetails.getSalarioMensual()<10000){
            calcEval = 500;
        }else{
            calcEval = 1000;
        }
        return calcEval;
    }
}
