package com.example.heirs;

import com.example.rules.CommonSense;
import com.example.rules.InheritanceException;

public class Heir implements Inheritable{

	private String heirtype;
    private int heirnb;
	private double inheritedvalue;
	private boolean blocked = false;
	private String blockreason;
	
	
	public String getblockreason() {
		return this.blockreason;
	}
	
	public void setblockreason(String blockreason) {
		this.blockreason = blockreason;
	}
	
	public Heir(String heirtype, int heirnb) {
		this.heirtype = heirtype;
        this.heirnb = heirnb;
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
    public int getHeirnb(){
        return this.heirnb;
    }

    public void setHeirnb(int heirnb){
        this.heirnb = heirnb;
    }
	
	public double getinheritedvalue() {
		
		return this.inheritedvalue;
		
	}
	
	public void setinheritedvalue(double inheritedvalue) {

        this.inheritedvalue = inheritedvalue;
	}

    public boolean isHusband()
    {
        if (this.heirtype.equals(HUSBAND) && this.heirnb > 0)
            return true;
        else return false;
    }

    public boolean isWife()
    {

        if (this.heirtype.equals(WIFE) && this.heirnb > 0)
            return true;
        else return false;
    }

    public boolean isSon()
    {
        if (this.heirtype.equals(SON) && this.heirnb > 0)
            return true;
        else return false;
    }

    public boolean isDaughter()
    {
        if (this.heirtype.equals(DAUGTHER)&&this.heirnb > 0)
            return true;
        else return false;
    }

    public boolean isGrandSon()
    {
        if (this.heirtype.equals(GRANDSON)&&this.heirnb > 0)
            return true;
        else return false;
    }

    public boolean isGrandDaughter()
    {
        if (this.heirtype.equals(GRANDDAUGHTER)&&this.heirnb > 0)
            return true;
        else return false;
    }

    public boolean isFather()
    {
        if (this.heirtype.equals(FATHER)&&this.heirnb > 0)
            return true;
        else return false;
    }

    public boolean isMother()
    {
        if (this.heirtype.equals(MOTHER)&&this.heirnb > 0)
            return true;
        else return false;
    }

    public boolean isGrandFather()
    {
        if (this.heirtype.equals(GRANDFATHER)&&this.heirnb > 0)
            return true;
        else return false;
    }

    public boolean isPaternalGrandMother()
    {
        if (this.heirtype.equals(PATERNAL_GRANDMOTHER)&&this.heirnb > 0)
            return true;
        else return false;
    }

    public boolean isMaternalGrandMother()
    {
        if (this.heirtype.equals(MATERNAL_GRANDMOTHER)&&this.heirnb > 0)
            return true;
        else return false;
    }

    public boolean isFullBrother()
    {
        if (this.heirtype.equals(FULL_BROTHER)&&this.heirnb > 0)
            return true;
        else return false;
    }

    public boolean isFullSister()
    {
        if (this.heirtype.equals(FULL_SISTER)&&this.heirnb > 0)
            return true;
        else return false;
    }

    public boolean isPaternalBrother()
    {
        if (this.heirtype.equals(PATERNAL_BROTHER)&&this.heirnb > 0)
            return true;
        else return false;
    }

    public boolean isPaternalSister()
    {
        if (this.heirtype.equals(PATERNAL_SISTER)&&this.heirnb > 0)
            return true;
        else return false;
    }

    public boolean isMaternalBrother()
    {
        if (this.heirtype.equals(MATERNAL_BROTHER)&&this.heirnb > 0)
            return true;
        else return false;
    }

    public boolean isMaternalSister()
    {
        if (this.heirtype.equals(MATERNAL_SISTER)&&this.heirnb > 0)
            return true;
        else return false;
    }

    public boolean isNephew()
    {
        if (this.heirtype.equals(NEPHEW)&&this.heirnb > 0)
            return true;
        else return false;
    }

    public boolean isPaternalNephew()
    {
        if (this.heirtype.equals(PATERNAL_NEPHEW)&&this.heirnb > 0)
            return true;
        else return false;
    }

    public boolean isNephewSon()
    {
        if (this.heirtype.equals(NEPHEWS_SON)&&this.heirnb > 0)
            return true;
        else return false;
    }

    public boolean isPaternalNephewSon()
    {
        if (this.heirtype.equals(PATERNAL_NEPHEWS_SON)&&this.heirnb > 0)
            return true;
        else return false;
    }

    public boolean isUncle()
    {
        if (this.heirtype.equals(UNCLE)&&this.heirnb > 0)
            return true;
        else return false;
    }

    public boolean isPaternalUncle()
    {
        if (this.heirtype.equals(PATERNAL_UNCLE)&&this.heirnb > 0)
            return true;
        else return false;
    }

    public boolean isCousin()
    {
        if (this.heirtype.equals(COUSIN)&&this.heirnb > 0)
            return true;
        else return false;
    }

    public boolean isPaternalCousin()
    {
        if (this.heirtype.equals(PATERNAL_COUSIN)&&this.heirnb > 0)
            return true;
        else return false;
    }

    public boolean isPaternalCousinSon()
    {
        if (this.heirtype.equals(PATERNAL_COUSINS_SON)&&this.heirnb > 0)
            return true;
        else return false;
    }

    public boolean isCousinGrandson()
    {
        if (this.heirtype.equals(COUSINS_GRANDSON)&&this.heirnb > 0)
            return true;
        else return false;
    }

    public boolean isPaternalCousinGrandson()
    {
        if (this.heirtype.equals(PATERNAL_COUSINS_GRANDSON)&&this.heirnb > 0)
            return true;
        else return false;
    }

    public boolean isCousinSon()
    {
        if (this.heirtype.equals(COUSINS_SON)&&this.heirnb > 0)
            return true;
        else return false;
    }

}











