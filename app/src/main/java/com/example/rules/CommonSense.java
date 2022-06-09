package com.example.rules;

import com.example.heirs.Deceased;
import com.example.heirs.Heir;
import com.example.heirs.Person;
import static com.example.heirs.Inheritable.HUSBAND;
import static com.example.heirs.Inheritable.WIFE;

import java.util.List;


public final class CommonSense {
	
	public static void spouseChecker(Deceased deceased, String heirType) throws InheritanceException
    {
        if(heirType.equals(HUSBAND) || heirType.equals(WIFE))
        {
            //Get the deceased gender
            String deceasedGender = deceased.getGender();
            //Prepare an error message in case...
            String errorMessage = "The deceased is a " + deceasedGender + ", the spouse cannot be " + heirType;
            switch(deceasedGender)
            {
                //Deceased is a male
                case Person.MALE:
                    if(heirType.equals(WIFE))
                        break;
                    else
                        throw new InheritanceException(errorMessage);//Male deceased cannot have husband
                //Deceased is a female
                case Person.FEMALE:
                    if(heirType.equals(HUSBAND))
                        break;
                    else
                        throw new InheritanceException(errorMessage);//Female deceased cannot have wife
            }
        }
        else
            throw new IllegalArgumentException("This method requires either " + HUSBAND + " or " + WIFE + " as the second argument");
        
    }
        
        
	public static boolean hasMaximumWives(Deceased deceased) throws IllegalArgumentException
    {
        if(deceased.getGender().equals(Person.MALE)) //The deceased must be male
        {
            List<Heir> heirs = deceased.getHeirs();
            int noOfWives = 0;
            for(Heir heir : heirs)
                if(heir.isWife())
                    noOfWives++;
            if(noOfWives < 4)
                return false;
            else
                return true;
        }
        else
            throw new IllegalArgumentException("This method requires a male as the deceased."); //The deceased must be male
    }
    

}
