package edu.isi.bmkeg.ooevv.services.impl;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.flex.remoting.RemotingDestination;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.isi.bmkeg.ooevv.dao.ExtendedOoevvDao;
import edu.isi.bmkeg.ooevv.model.OoevvElementSet;
import edu.isi.bmkeg.ooevv.services.ExtendedOoevvService;
import edu.isi.bmkeg.ooevv.utils.OoevvExcelEngine;

@RemotingDestination
@Transactional
@Service
public class ExtendedOoevvServiceImpl implements ExtendedOoevvService {

	private static final Logger logger = Logger.getLogger(ExtendedOoevvServiceImpl.class);

	@Autowired
	private ExtendedOoevvDao extOoevvDao;

	public void setooevvDao(ExtendedOoevvDao ooevvDao) {
		this.extOoevvDao = ooevvDao;
	}
	
	public Long uploadExcelFile(byte[] excelFileData, boolean lookup) throws Exception {
		
		OoevvExcelEngine xlEngine = new OoevvExcelEngine();
			
		OoevvElementSet exptVbSet = xlEngine.createExpVariableSetFromExcel(excelFileData, lookup);

		extOoevvDao.insertOoevvElementSetInDatabase(exptVbSet);
		
		return exptVbSet.getVpdmfId();
		
	}
	
	/*public Long generateExcelFile(OoevvElementSet oes) throws Exception {
		
		OoevvExcelEngine xlEngine = new OoevvExcelEngine();
						
		xlEngine.generateOoevvExcelWorkbook(file, exptVbSet)generateBlankOoevvExcelWorkbook(ooevvSheet);
		
		
		OoevvExcelEngine xlEngine = new OoevvExcelEngine();
			
		OoevvElementSet exptVbSet = xlEngine.createExpVariableSetFromExcel(excelFileData, lookup);

		extOoevvDao.insertOoevvElementSetInDatabase(exptVbSet);
		
		return exptVbSet.getVpdmfId();
		
	}*/
	

}