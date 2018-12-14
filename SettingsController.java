package com.pointel.settings;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.pointel.settings.bean.Database;
import com.pointel.settings.bean.General;
import com.pointel.settings.bean.Logger;
import com.pointel.settings.bean.Login;

@Controller
public class SettingsController {

	@Autowired
	private SettingsService settingsService;
	
	@RequestMapping(value = "/Login.html", method = RequestMethod.GET)
	public String loginGet(HttpSession httpSession) {

		if (httpSession.getAttribute("userName") != null) {
			return "redirect:Database.html";
		}
		
		return "Login";
	}
	
	@RequestMapping(value = "/Login.html", method = RequestMethod.POST)
	public String loginPost(Model model, HttpSession httpSession,
			@RequestParam("userName") String username, @RequestParam("password") String password) {
 
		boolean isValidSettingsCredential = settingsService.isValidSettingsCredential(username, password);
		
		if (isValidSettingsCredential) {
			httpSession.setAttribute("userName", username);
			
			return "redirect:Database.html";
		}
		
		model.addAttribute("message", "Invalid user name and password.");
		return "Login";
	}
	
	@RequestMapping(value = "/Logout.html", method = RequestMethod.GET)
	public String logoutGet(HttpSession httpSession) {

		httpSession.invalidate();
		
		return "redirect:Login.html";
	}
	
	@RequestMapping(value = "/Database.html", method = RequestMethod.GET)
	public String databaseGet(Model model, HttpSession httpSession) {

		if (httpSession.getAttribute("userName") == null) {
			return "redirect:Login.html";
		}
		
		model.addAttribute("database", settingsService.getDatabaseProperties());
		
		return "Database";
	}

	@RequestMapping(value = "/Database.html", method = RequestMethod.POST)
	public String databasePost( @RequestParam("ip") String ip,
			@RequestParam("port") String port, @RequestParam("dbName") String dbName,
			@RequestParam("userName") String userName,@RequestParam("password") String password, Model model) {

		Database database = new Database();
		
		database.setIp(ip);
		database.setPort(port);
		database.setDbName(dbName);
		database.setUserName(userName);
		database.setPassword(password);
		
		settingsService.setDatabaseProperties(database);

		model.addAttribute("database", settingsService.getDatabaseProperties());
		return "Database";
	}

	@RequestMapping(value = "/Logger.html", method = RequestMethod.GET)
	public String loggerGet(Model model, HttpSession httpSession) {

		if (httpSession.getAttribute("userName") == null) {
			return "redirect:Login.html";
		}
		
		model.addAttribute("logger", settingsService.getLoggerProperties());

		return "Logger";
	}

	@RequestMapping(value = "/Logger.html", method = RequestMethod.POST)
	public String loggerPost(@RequestParam("fileName") String fileName,@RequestParam("filePath") String filePath,
			@RequestParam("fileSize") String fileSize, @RequestParam("fileCount") String fileCount, Model model) {

		Logger logger = new Logger();
		
		logger.setFileName(fileName);
		logger.setFilePath(filePath);
		logger.setFileSize(fileSize);
		logger.setFileCount(fileCount);
		
		settingsService.setLoggerProperties(logger);

		model.addAttribute("logger", settingsService.getLoggerProperties());

		return "Logger";
	}

	@RequestMapping(value = "/General.html", method = RequestMethod.GET)
	public String generalGet(Model model,HttpSession httpSession ) {
		
		if (httpSession.getAttribute("userName") == null) {
			return "redirect:Login.html";
		}

		model.addAttribute("general", settingsService.getGeneralProperties());
		
		return "General";
	}

	@RequestMapping(value = "/General.html", method = RequestMethod.POST)
	public String loggerPost(@RequestParam("dateFormat") String dateFormat, @RequestParam("timeFormat") String timeFormat,
			@RequestParam("dateTimeFormat") String dateTimeFormat, Model model) {
		
		General general = new General();
		general.setDateFormat(dateFormat);
		general.setTimeFormat(timeFormat);
		general.setDateTimeFormat(dateTimeFormat);
		settingsService.setGeneralProperties(general);

		model.addAttribute("general", settingsService.getGeneralProperties());
		return "General";
	}

	@RequestMapping(value = "/ChangePassword.html", method = RequestMethod.GET)
	public String changePasswordGet(Model model ,HttpSession httpSession) {

		if (httpSession.getAttribute("userName") == null) {
			return "redirect:Login.html";
		}
		
		return "ChangePassword";
	}

	@RequestMapping(value = "/ChangePassword.html", method = RequestMethod.POST)
	public String loginPost(@RequestParam("oldPassword") String oldPassword, @RequestParam("password") String password, Model model) {

		if (settingsService.getLoginProperties().getPassword().equals(oldPassword)) {
			Login login = new Login();
			login.setPassword(password);

			settingsService.setLoginProperties(login);
			model.addAttribute("message", "Property file updated successfully.!");
			
		} else {
			model.addAttribute("message", "Invalid old password.");
		}
		
		return "ChangePassword";
	}
	
}