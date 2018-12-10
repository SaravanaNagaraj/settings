package com.pointel.settings;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
/*import org.springframework.ui.Model;*/
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.pointel.settings.bean.Database;

@Controller
public class SettingsController {

	@Autowired
	private SettingsService settingsService;

	@RequestMapping(value = "/Database.html", method = RequestMethod.GET)
	public String databaseGet(Model model) {

		model.addAttribute("database", settingsService.getDatabaseProperties());

		return "Database";

	}

	@RequestMapping(value = "/Database.html", method = RequestMethod.POST)
	public String databasePost(@RequestParam("username") String name, @RequestParam("ip") String ip,
			@RequestParam("port") String port, @RequestParam("dbname") String dbname,
			@RequestParam("password") String password) {

		System.out.println(name);
		
		Database database = new Database();
		database.setIp(ip);
		database.setPort(port);
		database.setPassword(password);
		database.setDbname(dbname);
		database.setUsername(name);
		settingsService.setDatabaseProperties(database);

		return "Database";

	}

}
