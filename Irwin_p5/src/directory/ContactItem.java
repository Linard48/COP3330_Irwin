package directory;

public class ContactItem

{ public String name;

    public String email;

    public long telephone;

    public String getName()

    {return name;

    }

    public long getphone()

    {return telephone;

    }

    public String getEmail()

    {return email;

    }

    public String toString()

    {return "Name: "+name+" \nAddress: "+email+"\nTelephone: "+telephone;

    }

}