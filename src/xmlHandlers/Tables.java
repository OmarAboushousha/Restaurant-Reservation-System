package xmlHandlers;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import restaurant.table.Table;
@XmlRootElement(name = "tables")
@XmlAccessorType(XmlAccessType.FIELD)
public class Tables {
	
	@XmlElement(name = "table")
	private List<Table> tables = new ArrayList<>();

}
