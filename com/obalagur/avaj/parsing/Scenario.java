package obalagur.avaj.parsing;

import java.util.ArrayList;
import java.util.List;

import obalagur.avaj.exceptions.AvajException;
import obalagur.avaj.exceptions.ExceptionTypes;
import obalagur.avaj.utils.FileSys;
import obalagur.avaj.utils.Hasher;
import obalagur.avaj.utils.Streamer;

public class Scenario {
	private int					simulationSize = 1;
	
	private boolean				status = true;
	
	private List<ScenarioInst>	instances;
	private List<String>		readScenario;
	
	public Scenario() {
		instances = new ArrayList<ScenarioInst>();
	}
	public int getSimulationSize() {
		return simulationSize;
	}
	public List<ScenarioInst> getInstances() {
		return instances;
	}
	public void setInputFile(String file) throws AvajException {
		if (file.isEmpty()) {
			status = false;
			throw (new AvajException(ExceptionTypes.EMPTY_INPUT));
		}
		if (!FileSys.exists(file)) {
			status = false;
			throw (new AvajException(ExceptionTypes.NO_FILE));
		}
		if (FileSys.isDir(file)) {
			status = false;
			throw (new AvajException(ExceptionTypes.NO_FILE));
		}
		
		readScenario = Streamer.read(file);
		
		if (readScenario.size() < 2){
			status = false;
			throw (new AvajException(ExceptionTypes.NO_DATA));
		}
	}
	public void parse() {
		if (status == false)
			return ;
		try {
			parseSimulationSize(readScenario.get(0));
			if (simulationSize <= 0)
				simulationSize = 1;
		} catch (AvajException e) {
			e.printStackTrace();
		}
		try {
			for (int i = 1; i < readScenario.size(); i++) {
				String line = readScenario.get(i);
				ScenarioInst scenarioInst = new ScenarioInst(line);
				instances.add(scenarioInst);
			}
		} catch (AvajException e) {
			status = false;
			e.printStackTrace();
		}
	}
	
	private void parseSimulationSize(String line) throws AvajException {
		if (Hasher.isHashed(line)) {
			for (int i = 0; i < 101; i++)
				if (line.equals( Hasher.getMd5(String.valueOf(i)).toUpperCase()))
					simulationSize = i;
		} else {
			if (FileSys.isDigit(line)) {
				if (line.length() <= 3) {
					simulationSize = Integer.parseInt(line);
				} else {
					simulationSize = 100;
					throw (new AvajException(ExceptionTypes.NO_TYPE));
				}
			} else {
				simulationSize = 1;
				throw (new AvajException(ExceptionTypes.NOT_DIGIT));
			}
		}
	}
	public boolean getStatus() {
		return status;
	}
	
}
