package com.example.heirs;

import com.example.rules.CommonSense;
import com.example.rules.InheritanceException;

public class Heir implements Inheritable{

	private String heirtype;
	private double inheritedvalue;
	private boolean blocked;
	private String blockreason;
	
	
	public String getblockreason() {
		return this.blockreason;
	}
	
	public void setblockreason(String blockreason) {
		this.blockreason = blockreason;
	}
	
	public Heir(String heirtype) {
		this.heirtype = heirtype;
	}
	
	
	public boolean isBlocked()
    {
        return blocked;
    }

    public void doBlock()
    {
        this.blocked = true;
    }

    public boolean isBlockable()
    {
        boolean blockable = false;
        if(this.isGrandSon() || this.isGrandDaughter() || this.isFullBrother() || this.isFullSister() || this.isPaternalBrother()
                || this.isPaternalSister() || this.isMaternalBrother() || this.isMaternalSister() || this.isNephew()
                || this.isPaternalNephew() || this.isNephewSon() || this.isPaternalNephewSon() || this.isUncle() || this.isPaternalUncle()
                || this.isCousin() || this.isPaternalCousin() || this.isCousinSon() || this.isPaternalCousinSon() || this.isCousinGrandson()
                || this.isPaternalCousinGrandson())
            blockable = true;
        return blockable;
    }
	

	@Override
	public String getheirtype() {
		// TODO Auto-generated method stub
		return heirtype;
	}

	@Override
	public void setheirtype(Deceased deceased, String heirtype) throws InheritanceException {
		// TODO Auto-generated method stub
		if(heirtype.equals(HUSBAND) || heirtype.equals(WIFE))
            CommonSense.spouseChecker(deceased, heirtype);
        this.heirtype = heirtype;
				
	}
	
	public double getinheritedvalue() {
		
		return this.inheritedvalue;
		
	}
	
	public void setinheritedvalue(double inheritedvalue) {
		this.inheritedvalue = inheritedvalue;
	}
	
	public boolean isSpouse()
    {
        return this.heirtype.equals(HUSBAND) || this.heirtype.equals(WIFE);
    }

    public boolean isHusband()
    {
        return this.heirtype.equals(HUSBAND);
    }

    public boolean isWife()
    {
        return this.heirtype.equals(WIFE);
    }

    public boolean isSon()
    {
        return this.heirtype.equals(SON);
    }

    public boolean isDaughter()
    {
        return this.heirtype.equals(DAUGTHER);
    }

    public boolean isGrandSon()
    {
        return this.heirtype.equals(GRANDSON);
    }

    public boolean isGrandDaughter()
    {
        return this.heirtype.equals(GRANDDAUGHTER);
    }

    public boolean isFather()
    {
        return this.heirtype.equals(FATHER);
    }

    public boolean isMother()
    {
        return this.heirtype.equals(MOTHER);
    }

    public boolean isGrandFather()
    {
        return this.heirtype.equals(GRANDFATHER);
    }

    public boolean isPaternalGrandMother()
    {
        return this.heirtype.equals(PATERNAL_GRANDMOTHER);
    }

    public boolean isMaternalGrandMother()
    {
        return this.heirtype.equals(MATERNAL_GRANDMOTHER);
    }

    public boolean isFullBrother()
    {
        return this.heirtype.equals(FULL_BROTHER);
    }

    public boolean isFullSister()
    {
        return this.heirtype.equals(FULL_SISTER);
    }

    public boolean isPaternalBrother()
    {
        return this.heirtype.equals(PATERNAL_BROTHER);
    }

    public boolean isPaternalSister()
    {
        return this.heirtype.equals(PATERNAL_SISTER);
    }

    public boolean isMaternalBrother()
    {
        return this.heirtype.equals(MATERNAL_BROTHER);
    }

    public boolean isMaternalSister()
    {
        return this.heirtype.equals(MATERNAL_SISTER);
    }

    public boolean isNephew()
    {
        return this.heirtype.equals(NEPHEW);
    }

    public boolean isPaternalNephew()
    {
        return this.heirtype.equals(PATERNAL_NEPHEW);
    }

    public boolean isNephewSon()
    {
        return this.heirtype.equals(NEPHEWS_SON);
    }

    public boolean isPaternalNephewSon()
    {
        return this.heirtype.equals(PATERNAL_NEPHEWS_SON);
    }

    public boolean isUncle()
    {
        return this.heirtype.equals(UNCLE);
    }

    public boolean isPaternalUncle()
    {
        return this.heirtype.equals(PATERNAL_UNCLE);
    }

    public boolean isCousin()
    {
        return this.heirtype.equals(COUSIN);
    }

    public boolean isPaternalCousin()
    {
        return this.heirtype.equals(PATERNAL_COUSIN);
    }

    public boolean isPaternalCousinSon()
    {
        return this.heirtype.equals(PATERNAL_COUSINS_SON);
    }

    public boolean isCousinGrandson()
    {
        return this.heirtype.equals(COUSINS_GRANDSON);
    }

    public boolean isPaternalCousinGrandson()
    {
        return this.heirtype.equals(PATERNAL_COUSINS_GRANDSON);
    }

    public boolean isCousinSon()
    {
        return this.heirtype.equals(COUSINS_SON);
    }

}











