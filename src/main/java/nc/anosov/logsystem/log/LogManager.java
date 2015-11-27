/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package nc.anosov.logsystem.log;

import nc.anosov.logsystem.level.Level;
import nc.anosov.logsystem.util.Util;
import nc.anosov.logsystem.util.XMLConfig;

public class LogManager {
        
    private static LogManager _instance;
	private LogManager(){
	}
	
	
	public static LogManager getInstance(){
		if(_instance == null){
			synchronized (LogManager.class) {
				if(_instance == null)
					_instance = new LogManager();
			}
		}
		return _instance;
	}
        public static Logger getLogger(String name){
        	Logger log  = new Logger(name);
        	return log;
        }
        
        public static Logger getLogger(String name, String path){
        	XMLConfig xml = new XMLConfig(path);
        	Logger log = new Logger(name);
        	log.setOutput(Util.getOutput(xml.parseOutput()));
        	log.setLevel(Util.getLevel(xml.parseLevel()));
        	log.setMessage(Util.getMessage(xml.parseMessage()));
        	return log;
        }
}
