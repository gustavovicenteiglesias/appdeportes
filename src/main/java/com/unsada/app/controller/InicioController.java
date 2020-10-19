package com.unsada.app.controller;






import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.SQLFeatureNotSupportedException;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.ResourceUtils;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.unsada.app.service.ProfesorServiceApi;

import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;










@Controller
@RequestMapping
public class InicioController {
	@Autowired
	 DataSource datasource;
	
	
	@RequestMapping("/admin/tablaTecnico")
	public ModelAndView login() {
		return new ModelAndView("inicio");
	}
	@RequestMapping("/admin/map")
	public ModelAndView login1() {
		return new ModelAndView("inicio");
	}
	
	@RequestMapping("/admin/tables")
	public ModelAndView login2() {
		return new ModelAndView("inicio");
	}
	
	@RequestMapping("/")
	public ModelAndView login3() {
		return new ModelAndView("inicio");
	}
	/*@RequestMapping(value = "/api/abono/pdfReport/{id}",method=RequestMethod.GET)
	@ResponseBody
	public void getDocument(HttpServletResponse response,@PathVariable("id") Integer id) throws IOException, JRException, SQLException {
	
		//String sourceFileName = ResourceUtils
				//.getFile(ResourceUtils.CLASSPATH_URL_PREFIX + "Abono.jasper").getAbsolutePath();
		InputStream jasperStream = this.getClass().getResourceAsStream("/Abono.jasper");
		Map <String,Object> para = new HashMap<>();
		para.put("idjasper", id);
		para.put("nombreE", "GustavoV>");
	
		Connection conn = null;
        conn = DriverManager.getConnection(
                "jdbc:postgresql://localhost:5432/sertecnico","postgres", "1234");
		JasperReport jasperReport = (JasperReport) JRLoader.loadObject(jasperStream);
		JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, para, datasource.getConnection());
		
		response.setContentType("application/pdf");
		response.addHeader("Content-Disposition", "inline; filename=abono"+id+".pdf;");
		
		final OutputStream outStream = response.getOutputStream();
	    JasperExportManager.exportReportToPdfStream(jasperPrint, outStream);
	}
	 */
}
