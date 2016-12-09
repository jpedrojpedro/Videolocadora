package Model;

public class Client
{
	private int id;
	private String name;
	private String cpf;
	private String address;
	private String neighbor;
	private CityOptions city;
	private boolean isMan;
	private String telphone;
	private String cellphone;
	
	public Client ( int id, String name, String cpf, String address, String neighbor, CityOptions city,
					boolean isMan, String telphone, String cellphone )
	{
		this.id = id;
		this.name = name;
		this.cpf = cpf;
		this.address = address;
		this.neighbor = neighbor;
		this.city = city;
		this.isMan = isMan;
		this.telphone = telphone;
		this.cellphone = cellphone;
	}

	public int getId()
	{
		return id;
	}
	
	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public String getCpf()
	{
		return cpf;
	}

	public void setCpf(String cpf)
	{
		this.cpf = cpf;
	}

	public String getAddress()
	{
		return address;
	}

	public void setAddress(String address)
	{
		this.address = address;
	}

	public String getNeighbor()
	{
		return neighbor;
	}

	public void setNeighbor(String neighbor)
	{
		this.neighbor = neighbor;
	}

	public CityOptions getCity()
	{
		return city;
	}

	public void setCity(CityOptions city)
	{
		this.city = city;
	}

	public boolean isMan()
	{
		return this.isMan;
	}

	public void setMan(boolean isMan)
	{
		this.isMan = isMan;
	}

	public String getTelphone()
	{
		return telphone;
	}

	public void setTelphone(String telphone)
	{
		this.telphone = telphone;
	}

	public String getCellphone()
	{
		return cellphone;
	}

	public void setCellphone(String cellphone)
	{
		this.cellphone = cellphone;
	}
}