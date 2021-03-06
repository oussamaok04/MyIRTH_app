package com.example.heirs;

import com.example.rules.CommonSense;
import com.example.rules.InheritanceException;

import java.util.ArrayList;
import java.util.List;


public class Deceased extends Person{
	
	private double legacy;
	private String gender = "Male";
	public static final String MALE = "Male";
	public static final String FEMALE = "Female";
    private List<Heir> heirs = new ArrayList<>();
	
	
	
	
	public Deceased(String gender , double legacy) {
        super(gender);
        this.legacy = legacy;
	}
	
	public boolean hasoffspring() {
		for(Heir heir : this.heirs)
			if(heir.isSon() || heir.isDaughter())
				return true;
		return false;
	}
	
	
	public void addHeir(Heir heir){

        this.heirs.add(heir);
    }
	
	
	
	public boolean hasHusband() {
		
		for(Heir heir : this.heirs)
			if(heir.isHusband())
				return true;
		return false;
		
	}
	
	
	public boolean hasOnlyOneDaughter() {

		for(Heir heir : this.heirs) {
			if(heir.isDaughter() && heir.getHeirnb() == 1)
                return true;
		}
		return false;
	}
	
	
	public boolean hasMultipleDaughter()
    {
        for(Heir heir : this.heirs)
            if(heir.isDaughter() && heir.getHeirnb() > 1)
                return true;
        return false;
    }
	
	
	public boolean hasNoSon()
    {
        for(Heir heir : this.heirs)
            if(heir.isSon())
                return false;
        return true;
    }

    public boolean hasSon()
    {
        return !this.hasNoSon();
    }
    
    
    
    public boolean hasOnlyOneGrandDaughterFromASon()
    {
        int noOfGrandDaughter = 0;
        for(Heir heir : this.heirs)
            if(heir.isGrandDaughter())
                noOfGrandDaughter++;
        if(noOfGrandDaughter > 1)
            return false;
        if(noOfGrandDaughter == 1)
            return true;
        else
            return false;
    }

    public boolean hasManyGrandDaughterFromSon()
    {
        int noOfGrandDaughter = 0;
        for(Heir heir : this.heirs)
            if(heir.isGrandDaughter())
                noOfGrandDaughter++;
        if(noOfGrandDaughter > 1)
            return true;
        else
            return false;
    }



    public boolean hasNoGrandSonFromSon()
    {
        for(Heir heir : this.heirs)
            if(heir.isGrandSon() && heir.getHeirnb()!=0)
                return false;
        return true;
    }

    public boolean hasGrandSonFromSon()
    {
        return !this.hasNoGrandSonFromSon();
    }
	
    
    public boolean hasNotMultipleSiblings()
    {
        int noOfSiblings = 0;
        for(Heir heir : this.heirs)
            if(heir.isFullBrother() || heir.isFullSister() || heir.isMaternalBrother() || heir.isMaternalSister()
                    || heir.isPaternalBrother() || heir.isPaternalSister() && heir.getHeirnb()!=0)
                return false;
        return true;
    }

    public boolean hasMultipleSiblings()
    {
        return !this.hasNotMultipleSiblings();
    }
    
    
    
    public boolean hasFather() {

        return !this.hasNoFather();
    }

    public boolean hasNoFather()
    {
        for(Heir heir : this.heirs)
            if(heir.isFather())
                return false;
        return true;
    }

    public boolean hasNotMother()
    {
        for(Heir heir : this.heirs)
            if(heir.isMother())
                return false;
        return true;
    }

    public boolean hasNotMaternalGrandMother()
    {
        for(Heir heir : this.heirs)
            if(heir.isMaternalGrandMother())
                return false;
        return true;
    }

    public boolean hasNotPaternalGrandMother()
    {
        for(Heir heir : this.heirs)
            if(heir.isPaternalGrandMother())
                return false;
        return true;
    }

    public boolean hasOnlyOneFullSister()
    {
        for(Heir heir : this.heirs)
            if(heir.isFullSister() && heir.getHeirnb() == 1)
                return true;
        return false;
    }

    
    
    public boolean hasNoMalePaternalAncestor()
    {
        for(Heir heir : this.heirs)
            if(heir.isFather() || heir.isGrandFather())
                return false;
        return true;
    }

    public boolean hasNoFullBrother()
    {
        for(Heir heir : this.heirs)
            if(heir.isFullBrother())
                return false;
        return true;
    }

    public boolean hasManyFullSisters()
    {
        for(Heir heir : this.heirs)
            if(heir.isFullSister() && heir.getHeirnb() > 1)
                return true;
        return false;
    }

    public boolean hasOnlyOnePaternalSister()
    {
        for(Heir heir : this.heirs)
            if(heir.isPaternalSister() && heir.getHeirnb() == 1)
            {
                    return true;
            }
        return false;
    }

    public boolean hasOnlyOneMaternalSibling()
    {
        int noOfMaternalSibling = 0;
        for(Heir heir : this.heirs)
            if(heir.isMaternalBrother() || heir.isMaternalSister() && heir.getHeirnb() == 1)
            {
                    return true;
            }
        return false;
    }

    public boolean hasManyMaternalSibling()
    {
        return !this.hasOnlyOneMaternalSibling();
    }

    public boolean hasNoFullSiblingOrPaternalBrother()
    {
        for(Heir heir : this.heirs)
            if(heir.isFullBrother() || heir.isFullSister() || heir.isPaternalBrother())
                return false;
        return true;
    }

    public boolean hasNoPaternalBrother()
    {
        for(Heir heir : this.heirs)
            if(heir.isPaternalBrother())
                return false;
        return true;
    }

    public boolean hasMultiplePaternalSisters()
    {
        for(Heir heir : this.heirs)
            if(heir.isPaternalSister() && heir.getHeirnb() > 1)
                return true;
        return false;
    }

    public boolean hasGrandFather()
    {
        for(Heir heir : this.heirs)
            if(heir.isGrandFather())
                return true;
        return false;
    }

    public boolean hasNephew()
    {
        for(Heir heir : this.heirs)
            if(heir.isNephew())
                return true;
        return false;
    }

    public boolean hasPaternalNephew()
    {
        for(Heir heir : this.heirs)
            if(heir.isPaternalNephew())
                return true;
        return false;
    }

    public boolean hasNephewSon()
    {
        for(Heir heir : this.heirs)
            if(heir.isNephewSon())
                return true;
        return false;
    }

    public boolean hasPaternalNephewSon()
    {
        for(Heir heir : this.heirs)
            if(heir.isPaternalNephewSon())
                return true;
        return false;
    }

    public boolean hasUncle()
    {
        for(Heir heir : this.heirs)
            if(heir.isUncle())
                return true;
        return false;
    }
    
    

    public boolean hasPaternalUncle()
    {
        for(Heir heir : this.heirs)
            if(heir.isPaternalUncle())
                return true;
        return false;
    }

    public boolean hasCousin()
    {
        for(Heir heir : this.heirs)
            if(heir.isCousin())
                return true;
        return false;
    }

    public boolean hasPaternalCousin()
    {
        for(Heir heir : this.heirs)
            if(heir.isPaternalCousin())
                return true;
        return false;
    }

    public boolean hasCousinSon()
    {
        for(Heir heir : this.heirs)
            if(heir.isCousinSon())
                return true;
        return false;
    }

    public boolean hasPaternalCousinSon()
    {
        for(Heir heir : this.heirs)
            if(heir.isPaternalCousinSon())
                return true;
        return false;
    }

    public boolean hasCousinGrandSon()
    {
        for(Heir heir : this.heirs)
            if(heir.isCousinGrandson())
                return true;
        return false;
    }
	
	
	
	public double getLegacy() {
		return legacy;
	}
	
	
	public void setLegacy(double legacy) {
		this.legacy = legacy;
	}
	
	
	public String getGender() {
		return gender;
	}
	
	
	public void setGender(String gender) {
		this.gender = gender;
	}

	public List<Heir> getHeirs() {
		return heirs;
	}

	public void setHeirs(List<Heir> heirs) {
		this.heirs = heirs;
	}
	
	
	
}
