package com.example.heirs;

import com.example.rules.InheritanceException;

import com.example.rules.InheritanceException;

public interface Inheritable {

	
	 public static final String HUSBAND = "Husband";

	    public static final String WIFE = "Wife";

	    public static final String SON = "Son";

	    public static final String DAUGTHER = "Daughter";

	    public static final String GRANDSON = "Grandson";

	    public static final String GRANDDAUGHTER = "Granddaughter";

	    public static final String FATHER = "Father";

	    public static final String MOTHER = "Mother";

	    public static final String GRANDFATHER = "Grandfather";

	    public static final String PATERNAL_GRANDMOTHER = "Paternal Grandmother";

	    public static final String MATERNAL_GRANDMOTHER = "Maternal Grandmother";

	    public static final String FULL_BROTHER = "Full Brother";

	    public static final String FULL_SISTER = "Full Sister";

	    public static final String PATERNAL_BROTHER = "Paternal Brother";

	    public static final String PATERNAL_SISTER = "Paternal Sister";

	    public static final String MATERNAL_BROTHER = "Maternal Brother";

	    public static final String MATERNAL_SISTER = "Maternal Sister";

	    public static final String NEPHEW = "Nephew";

	    public static final String PATERNAL_NEPHEW = "Paternal Nephew";

	    public static final String NEPHEWS_SON = "Nephew's Son";

	    public static final String PATERNAL_NEPHEWS_SON = "Paternal Nephew's Son";

	    public static final String UNCLE = "Uncle";

	    public static final String PATERNAL_UNCLE = "Paternal Uncle";

	    public static final String COUSIN = "Cousin";

	    public static final String PATERNAL_COUSIN = "Paternal Cousin";

	    public static final String COUSINS_SON = "Cousin's Son";

	    public static final String PATERNAL_COUSINS_SON = "Paternal Cousin's Son";

	    public static final String COUSINS_GRANDSON = "Cousin's Grandson";

	    public static final String PATERNAL_COUSINS_GRANDSON = "Paternal Cousin's Grandson";
	    
	    public abstract String getheirtype();
	    
	    public abstract void setheirtype(Deceased deceased, String heirtype) throws InheritanceException, InheritanceException;
}
