/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package test;

import java.sql.Connection;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JOptionPane;
import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.view.JasperViewer;


/**
 *
 * @author JavierObeth
 */

public class reportes 
{
    
    public void contrato (String car, String prod, String mont, String has,
            String ubca, String montT, String letra)

    {
         try
        {
            

            Map parameter = new HashMap();
            parameter.put("TITULO","Contrado Crédito Simple "+prod+ "");
            parameter.put("cartera",car);
            parameter.put("prod",prod);
            parameter.put("mont",mont);
            parameter.put("has",has);
            parameter.put("ubcana",ubca);
            parameter.put("montTot",montT);
            parameter.put("letra",letra);
            JasperReport report=JasperCompileManager.compileReport("reportes\\test.jrxml");
            JasperPrint print=JasperFillManager.fillReport(report, parameter,new JREmptyDataSource());
            //JasperExportManager.exportReportToPdfFile(print,"C:\\tricho_zon_fecha.pdf");
            //JasperViewer.viewReport(print,false);
            JasperViewer visor= new JasperViewer(print,false);
                         visor.setTitle("Contrado Crédito Simple "+prod);
                         visor.setVisible(true);
        }
        catch (Exception e)
        {
            JOptionPane.showMessageDialog(null,"Ocurrio un error al generar el "
                    + "reporte.");
            JOptionPane.showMessageDialog(null,""+e.getMessage());
        }
    }
    
}
