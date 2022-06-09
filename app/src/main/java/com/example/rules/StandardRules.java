package com.example.rules;


import com.example.heirs.Deceased;
import com.example.heirs.Heir;
import com.example.heirs.Person;

import java.util.ArrayList;
import java.util.List;

public final class StandardRules {

    //husband share
    public static double getHusbandportion(Deceased deceased){
        if (deceased.hasoffspring()){
            return deceased.getLegacy() / 4.0;
        }else
            return deceased.getLegacy() / 2.0;
    }

    //wife share
    public static double getWifeportion(Deceased deceased , int noOfWifes) {
        if (deceased.hasoffspring()) {
            return deceased.getLegacy() / (8.0 * noOfWifes);
        } else
            return deceased.getLegacy() / (4.0 * noOfWifes);
    }

    //daughter share
    public static double getDaughterportion(Deceased deceased){

        int noOfDaughters = 0;
        int noOfSons = 0;
        int noOfWives = 0;

        double daughterportion = 0.0;
        double remainingportion = 0.0;

        List<Heir> theheirs = deceased.getHeirs();

        for (Heir heir: theheirs) {

            if (heir.isDaughter()) {
                noOfDaughters++;
            }
            else if (heir.isSon()) {
                noOfSons++;
            } else if (heir.isWife()) {
                noOfWives++;
            }
        }

        //there is no son case
        if (deceased.hasOnlyOneDaughter() && deceased.hasNoSon()){
            return deceased.getLegacy() / 2.0;
        } else if (deceased.hasMultipleDaughter() && deceased.hasNoSon()) {
            daughterportion = (deceased.getLegacy() * 2) / (3 * noOfDaughters);
        }

        //there is a son case
        else if (!deceased.hasNoSon()){

            List<Heir> unblockedheirs = new ArrayList<>();

            double husbandPortion = 0.0;
            double wifePortion = 0.0;
            double allGrandsonPortion = 0.0;
            double allGranddaughterPortion = 0.0;
            double fatherPortion = 0.0;
            double motherPortion = 0.0;
            double grandfatherPortion = 0.0;
            double paternalGrandmotherPortion = 0.0;
            double maternalGrandmotherPortion = 0.0;
            double allFullBrotherPortion = 0.0;
            double allFullSisterPortion = 0.0;
            double allPaternalBrotherPortion = 0.0;
            double allPaternalSisterPortion = 0.0;
            double allMaternalBrotherPortion = 0.0;
            double allMaternalSisterPortion = 0.0;
            double allNephewPortion = 0.0;
            double allPaternalNephewPortion = 0.0;
            double allNephewSonPortion = 0.0;
            double allPaternalNephewSonPortion = 0.0;
            double allUnclePortion = 0.0;
            double allPaternalUnclePortion = 0.0;
            double allCousinPortion = 0.0;
            double allPaternalCousinPortion = 0.0;
            double allCousinSonPortion = 0.0;
            double allPaternalCousinSonPortion = 0.0;
            double allCousinGrandsonPortion = 0.0;
            double allPaternalCousinGrandsonPortion = 0.0;

            for (Heir heir: theheirs) {

                if (heir.isBlockable()){

                    BlockingRules.blockingRuleA(deceased);
                    BlockingRules.blockingRuleB(deceased);
                    BlockingRules.blockingRuleC(deceased);
                    BlockingRules.blockingRuleD(deceased);
                    BlockingRules.blockingRuleE(deceased);
                    BlockingRules.blockingRuleF(deceased);
                    BlockingRules.blockingRuleG(deceased);
                    BlockingRules.blockingRuleH(deceased);
                    BlockingRules.blockingRuleI(deceased);
                    BlockingRules.blockingRuleK(deceased);
                    BlockingRules.blockingRuleL(deceased);
                    BlockingRules.blockingRuleM(deceased);
                    BlockingRules.blockingRuleN(deceased);
                    BlockingRules.blockingRuleO(deceased);
                    BlockingRules.blockingRuleP(deceased);
                    BlockingRules.blockingRuleQ(deceased);
                    BlockingRules.blockingRuleR(deceased);
                    BlockingRules.blockingRuleS(deceased);
                    BlockingRules.blockingRuleT(deceased);
                }

                if (heir.isBlocked() == false){

                    if (heir.isHusband()){
                        double thehusbandportion = StandardRules.getHusbandportion(deceased);
                        husbandPortion += thehusbandportion;
                    }

                    else if (heir.isWife()){
                        double thewifeportion = StandardRules.getWifeportion(deceased , noOfWives);
                        husbandPortion += thewifeportion;
                    }

                    else if (heir.isGrandSon()){
                        double thegrandsonportion = StandardRules.getGrandsonportion(deceased);
                        allGrandsonPortion += thegrandsonportion;
                    }

                    else if (heir.isGrandDaughter()){
                        double thegranddaughterportion = StandardRules.getGrandDaughterportion(deceased);
                        allGranddaughterPortion += thegranddaughterportion;
                    }

                    else if (heir.isFather()){
                        double thefatherportion = StandardRules.getFatherportion(deceased);
                        fatherPortion += thefatherportion;
                    }

                    else if (heir.isMother()){
                        double themotherportion = StandardRules.getMotherportion(deceased);
                        motherPortion += themotherportion;
                    }

                    else if (heir.isGrandFather()){
                        double thegrandfatherportion = StandardRules.getGrandFatherportion(deceased);
                        grandfatherPortion += thegrandfatherportion;
                    }

                    else if (heir.isPaternalGrandMother()){
                        double thepaternalgrandmotherportion = StandardRules.getPaternalGrandMotherportion(deceased);
                        paternalGrandmotherPortion += thepaternalgrandmotherportion;
                    }

                    else if(heir.isMaternalGrandMother())
                    {
                        double theMaternalGrandmotherPortion = StandardRules.getMaternalGrandMotherportion(deceased);
                        maternalGrandmotherPortion += theMaternalGrandmotherPortion;
                    }
                    else if(heir.isFullBrother())
                    {
                        double theFullBrotherportion = StandardRules.getFullBrotherportion(deceased);
                        allFullBrotherPortion += theFullBrotherportion;
                    }
                    else if(heir.isFullSister())
                    {
                        double theFullSisterPortion = StandardRules.getFullSisterportion(deceased);
                        allFullSisterPortion += theFullSisterPortion;
                    }
                    else if(heir.isPaternalBrother())
                    {
                        double thepaternalbrotherportion = StandardRules.getPaternalBrotherportion(deceased);
                        allPaternalBrotherPortion += thepaternalbrotherportion;
                    }
                    else if(heir.isPaternalSister())
                    {
                        double thePaternalSisterPortion = StandardRules.getPaternalSisterportion(deceased);
                        allPaternalSisterPortion += thePaternalSisterPortion;
                    }
                    else if(heir.isMaternalBrother())
                    {
                        double theMaternalBrotherPortion = StandardRules.getMaternalSiblingportion(deceased);
                        allMaternalBrotherPortion += theMaternalBrotherPortion;
                    }
                    else if(heir.isMaternalSister())
                    {
                        double theMaternalSisterPortion = StandardRules.getMaternalSiblingportion(deceased);
                        allMaternalSisterPortion += theMaternalSisterPortion;
                    }
                    else if(heir.isNephew())
                    {
                        double thenephewportion = StandardRules.getNephewportion(deceased);
                        allNephewPortion += thenephewportion;
                    }
                    else if(heir.isPaternalNephew())
                    {
                        double thePaternalNephewportion = StandardRules.getPaternalNephewportion(deceased);
                        allPaternalNephewPortion += thePaternalNephewportion;
                    }
                    else if(heir.isNephewSon())
                    {
                        double theNephewSonportion = StandardRules.getNephewSonportion(deceased);
                        allNephewSonPortion += theNephewSonportion;
                    }
                    else if(heir.isPaternalNephewSon())
                    {
                        double thePaternaNephewSonportion = StandardRules.getPaternalNephewSonportion(deceased);
                        allPaternalNephewSonPortion += thePaternaNephewSonportion;
                    }
                    else if(heir.isUncle())
                    {
                        double theUncleportion = StandardRules.getUncleportion(deceased);
                        allUnclePortion += theUncleportion;
                    }
                    else if(heir.isPaternalUncle())
                    {
                        double thePaternalUncleportion = StandardRules.getPaternalUncleportion(deceased);
                        allPaternalUnclePortion += thePaternalUncleportion;
                    }
                    else if(heir.isCousin())
                    {
                        double theCousinportion = StandardRules.getCousinportion(deceased);
                        allCousinPortion += theCousinportion;
                    }
                    else if(heir.isCousinSon())
                    {
                        double theCousinSonportion = StandardRules.getCousinSonportion(deceased);
                        allCousinSonPortion += theCousinSonportion;
                    }
                    else if(heir.isPaternalCousinSon())
                    {
                        double thePaternalCousinSonportion = StandardRules.getPaternalCousinSonportion(deceased);
                        allPaternalCousinSonPortion += thePaternalCousinSonportion;
                    }
                    else if(heir.isCousinGrandson())
                    {
                        double theCousinGrandsonportion = StandardRules.getCousinGrandsonportion(deceased);
                        allCousinGrandsonPortion += theCousinGrandsonportion;
                    }
                    else if(heir.isPaternalCousinGrandson())
                    {
                        double thePaternalCousinGrandsonportion = StandardRules.getPaternalCousinGrandsonportion(deceased);
                        allPaternalCousinGrandsonPortion += thePaternalCousinGrandsonportion;
                    }
                    unblockedheirs.add(heir);
                }
            }

            if(deceased.getGender().equals(Person.MALE)) {

                //we devide the legacy on the prescribed heirs first
                remainingportion = deceased.getLegacy() - (wifePortion + allGrandsonPortion + allGranddaughterPortion + fatherPortion
                        + motherPortion + grandfatherPortion + paternalGrandmotherPortion + maternalGrandmotherPortion
                        + allFullBrotherPortion + allFullSisterPortion + allPaternalBrotherPortion
                        + allPaternalSisterPortion + allMaternalBrotherPortion + allMaternalSisterPortion
                        + allNephewPortion + allPaternalNephewPortion + allNephewSonPortion + allPaternalNephewSonPortion
                        + allUnclePortion + allPaternalUnclePortion + allCousinPortion + allPaternalCousinPortion
                        + allCousinSonPortion + allPaternalCousinSonPortion + allCousinGrandsonPortion
                        + allPaternalCousinGrandsonPortion);

                //the daughter inherites as ASABAH (she inherites from what remains)
                daughterportion = remainingportion / (noOfDaughters + (noOfSons * 2));
            }
            else if(deceased.getGender().equals(Person.FEMALE)) {

                //we devide the legacy on the prescribed heirs first
                remainingportion = deceased.getLegacy() - (husbandPortion + allGrandsonPortion + allGranddaughterPortion + fatherPortion
                        + motherPortion + grandfatherPortion + paternalGrandmotherPortion + maternalGrandmotherPortion
                        + allFullBrotherPortion + allFullSisterPortion + allPaternalBrotherPortion
                        + allPaternalSisterPortion + allMaternalBrotherPortion + allMaternalSisterPortion
                        + allNephewPortion + allPaternalNephewPortion + allNephewSonPortion + allPaternalNephewSonPortion
                        + allUnclePortion + allPaternalUnclePortion + allCousinPortion + allPaternalCousinPortion
                        + allCousinSonPortion + allPaternalCousinSonPortion + allCousinGrandsonPortion
                        + allPaternalCousinGrandsonPortion);

                //the daughter inherites as ASABAH (she inherites from what remains)
                daughterportion = remainingportion / (noOfDaughters + (noOfSons * 2));
            }

        }

        return daughterportion;
    }

    //Son share
    public static double getSonPortion(Deceased deceased){

        int noOfDaughters = 0;
        int noOfWives = 0;
        int noOfSons = 0;

        double daughterportion = 0.0;
        double remainingportion = 0.0;
        double sonportion = 0.0;

        List<Heir> theheirs = deceased.getHeirs();

        for (Heir heir: theheirs){

            if (heir.isDaughter()){
                noOfDaughters++;
            } else if (heir.isWife()) {
                noOfWives++;
            } else if (heir.isSon()) {
                noOfSons++;
            }
        }

         if (!deceased.hasNoSon()){

            List<Heir> unblockedheirs = new ArrayList<>();

            double husbandPortion = 0.0;
            double wifePortion = 0.0;
            double allGrandsonPortion = 0.0;
            double allGranddaughterPortion = 0.0;
            double fatherPortion = 0.0;
            double motherPortion = 0.0;
            double grandfatherPortion = 0.0;
            double paternalGrandmotherPortion = 0.0;
            double maternalGrandmotherPortion = 0.0;
            double allFullBrotherPortion = 0.0;
            double allFullSisterPortion = 0.0;
            double allPaternalBrotherPortion = 0.0;
            double allPaternalSisterPortion = 0.0;
            double allMaternalBrotherPortion = 0.0;
            double allMaternalSisterPortion = 0.0;
            double allNephewPortion = 0.0;
            double allPaternalNephewPortion = 0.0;
            double allNephewSonPortion = 0.0;
            double allPaternalNephewSonPortion = 0.0;
            double allUnclePortion = 0.0;
            double allPaternalUnclePortion = 0.0;
            double allCousinPortion = 0.0;
            double allPaternalCousinPortion = 0.0;
            double allCousinSonPortion = 0.0;
            double allPaternalCousinSonPortion = 0.0;
            double allCousinGrandsonPortion = 0.0;
            double allPaternalCousinGrandsonPortion = 0.0;

            for (Heir heir: theheirs) {

                if (heir.isBlockable()){

                    BlockingRules.blockingRuleA(deceased);
                    BlockingRules.blockingRuleB(deceased);
                    BlockingRules.blockingRuleC(deceased);
                    BlockingRules.blockingRuleD(deceased);
                    BlockingRules.blockingRuleE(deceased);
                    BlockingRules.blockingRuleF(deceased);
                    BlockingRules.blockingRuleG(deceased);
                    BlockingRules.blockingRuleH(deceased);
                    BlockingRules.blockingRuleI(deceased);
                    BlockingRules.blockingRuleK(deceased);
                    BlockingRules.blockingRuleL(deceased);
                    BlockingRules.blockingRuleM(deceased);
                    BlockingRules.blockingRuleN(deceased);
                    BlockingRules.blockingRuleO(deceased);
                    BlockingRules.blockingRuleP(deceased);
                    BlockingRules.blockingRuleQ(deceased);
                    BlockingRules.blockingRuleR(deceased);
                    BlockingRules.blockingRuleS(deceased);
                    BlockingRules.blockingRuleT(deceased);
                }

                if (heir.isBlocked() == false){

                    if (heir.isHusband()){
                        double thehusbandportion = StandardRules.getHusbandportion(deceased);
                        husbandPortion += thehusbandportion;
                    }

                    else if (heir.isWife()){
                        double thewifeportion = StandardRules.getWifeportion(deceased , noOfWives);
                        husbandPortion += thewifeportion;
                    }

                    else if (heir.isGrandSon()){
                        double thegrandsonportion = StandardRules.getGrandsonportion(deceased);
                        allGrandsonPortion += thegrandsonportion;
                    }

                    else if (heir.isGrandDaughter()){
                        double thegranddaughterportion = StandardRules.getGrandDaughterportion(deceased);
                        allGranddaughterPortion += thegranddaughterportion;
                    }

                    else if (heir.isFather()){
                        double thefatherportion = StandardRules.getFatherportion(deceased);
                        fatherPortion += thefatherportion;
                    }

                    else if (heir.isMother()){
                        double themotherportion = StandardRules.getMotherportion(deceased);
                        motherPortion += themotherportion;
                    }

                    else if (heir.isGrandFather()){
                        double thegrandfatherportion = StandardRules.getGrandFatherportion(deceased);
                        grandfatherPortion += thegrandfatherportion;
                    }

                    else if (heir.isPaternalGrandMother()){
                        double thepaternalgrandmotherportion = StandardRules.getPaternalGrandMotherportion(deceased);
                        paternalGrandmotherPortion += thepaternalgrandmotherportion;
                    }

                    else if(heir.isMaternalGrandMother())
                    {
                        double theMaternalGrandmotherPortion = StandardRules.getMaternalGrandMotherportion(deceased);
                        maternalGrandmotherPortion += theMaternalGrandmotherPortion;
                    }
                    else if(heir.isFullBrother())
                    {
                        double theFullBrotherportion = StandardRules.getFullBrotherportion(deceased);
                        allFullBrotherPortion += theFullBrotherportion;
                    }
                    else if(heir.isFullSister())
                    {
                        double theFullSisterPortion = StandardRules.getFullSisterportion(deceased);
                        allFullSisterPortion += theFullSisterPortion;
                    }
                    else if(heir.isPaternalBrother())
                    {
                        double thepaternalbrotherportion = StandardRules.getPaternalBrotherportion(deceased);
                        allPaternalBrotherPortion += thepaternalbrotherportion;
                    }
                    else if(heir.isPaternalSister())
                    {
                        double thePaternalSisterPortion = StandardRules.getPaternalSisterportion(deceased);
                        allPaternalSisterPortion += thePaternalSisterPortion;
                    }
                    else if(heir.isMaternalBrother())
                    {
                        double theMaternalBrotherPortion = StandardRules.getMaternalSiblingportion(deceased);
                        allMaternalBrotherPortion += theMaternalBrotherPortion;
                    }
                    else if(heir.isMaternalSister())
                    {
                        double theMaternalSisterPortion = StandardRules.getMaternalSiblingportion(deceased);
                        allMaternalSisterPortion += theMaternalSisterPortion;
                    }
                    else if(heir.isNephew())
                    {
                        double thenephewportion = StandardRules.getNephewportion(deceased);
                        allNephewPortion += thenephewportion;
                    }
                    else if(heir.isPaternalNephew())
                    {
                        double thePaternalNephewportion = StandardRules.getPaternalNephewportion(deceased);
                        allPaternalNephewPortion += thePaternalNephewportion;
                    }
                    else if(heir.isNephewSon())
                    {
                        double theNephewSonportion = StandardRules.getNephewSonportion(deceased);
                        allNephewSonPortion += theNephewSonportion;
                    }
                    else if(heir.isPaternalNephewSon())
                    {
                        double thePaternaNephewSonportion = StandardRules.getPaternalNephewSonportion(deceased);
                        allPaternalNephewSonPortion += thePaternaNephewSonportion;
                    }
                    else if(heir.isUncle())
                    {
                        double theUncleportion = StandardRules.getUncleportion(deceased);
                        allUnclePortion += theUncleportion;
                    }
                    else if(heir.isPaternalUncle())
                    {
                        double thePaternalUncleportion = StandardRules.getPaternalUncleportion(deceased);
                        allPaternalUnclePortion += thePaternalUncleportion;
                    }
                    else if(heir.isCousin())
                    {
                        double theCousinportion = StandardRules.getCousinportion(deceased);
                        allCousinPortion += theCousinportion;
                    }
                    else if(heir.isCousinSon())
                    {
                        double theCousinSonportion = StandardRules.getCousinSonportion(deceased);
                        allCousinSonPortion += theCousinSonportion;
                    }
                    else if(heir.isPaternalCousinSon())
                    {
                        double thePaternalCousinSonportion = StandardRules.getPaternalCousinSonportion(deceased);
                        allPaternalCousinSonPortion += thePaternalCousinSonportion;
                    }
                    else if(heir.isCousinGrandson())
                    {
                        double theCousinGrandsonportion = StandardRules.getCousinGrandsonportion(deceased);
                        allCousinGrandsonPortion += theCousinGrandsonportion;
                    }
                    else if(heir.isPaternalCousinGrandson())
                    {
                        double thePaternalCousinGrandsonportion = StandardRules.getPaternalCousinGrandsonportion(deceased);
                        allPaternalCousinGrandsonPortion += thePaternalCousinGrandsonportion;
                    }
                    unblockedheirs.add(heir);
                }
            }

            if(deceased.getGender().equals(Person.MALE)) {

                //we devide the legacy on the prescribed heirs first
                remainingportion = deceased.getLegacy() - (wifePortion + allGrandsonPortion + allGranddaughterPortion + fatherPortion
                        + motherPortion + grandfatherPortion + paternalGrandmotherPortion + maternalGrandmotherPortion
                        + allFullBrotherPortion + allFullSisterPortion + allPaternalBrotherPortion
                        + allPaternalSisterPortion + allMaternalBrotherPortion + allMaternalSisterPortion
                        + allNephewPortion + allPaternalNephewPortion + allNephewSonPortion + allPaternalNephewSonPortion
                        + allUnclePortion + allPaternalUnclePortion + allCousinPortion + allPaternalCousinPortion
                        + allCousinSonPortion + allPaternalCousinSonPortion + allCousinGrandsonPortion
                        + allPaternalCousinGrandsonPortion);

                //the son will inherite as ASABAH (he inherites from what remains)
                daughterportion = remainingportion / (noOfDaughters + (noOfSons * 2));
                sonportion = 2 * daughterportion;
            }
            else if(deceased.getGender().equals(Person.FEMALE)) {

                //we devide the legacy on the prescribed heirs first
                remainingportion = deceased.getLegacy() - (husbandPortion + allGrandsonPortion + allGranddaughterPortion + fatherPortion
                        + motherPortion + grandfatherPortion + paternalGrandmotherPortion + maternalGrandmotherPortion
                        + allFullBrotherPortion + allFullSisterPortion + allPaternalBrotherPortion
                        + allPaternalSisterPortion + allMaternalBrotherPortion + allMaternalSisterPortion
                        + allNephewPortion + allPaternalNephewPortion + allNephewSonPortion + allPaternalNephewSonPortion
                        + allUnclePortion + allPaternalUnclePortion + allCousinPortion + allPaternalCousinPortion
                        + allCousinSonPortion + allPaternalCousinSonPortion + allCousinGrandsonPortion
                        + allPaternalCousinGrandsonPortion);

                //the son will inherite as ASABAH (he inherites from what remains)
                daughterportion = remainingportion / (noOfDaughters + (noOfSons * 2));
                sonportion = 2 * daughterportion;
            }

        }


        return sonportion;
    }

    private static double getGrandDaughterportion(Deceased deceased) {
        int noOfGrandDaughters = 0;
        Double grandDaughterPortion = 0.0;
        List<Heir> theHeirs = deceased.getHeirs();
        for(Heir theHeir : theHeirs)
        {
            if(theHeir.isGrandDaughter())
                ++noOfGrandDaughters;
        }
        if(deceased.hasOnlyOneGrandDaughterFromASon() && !deceased.hasoffspring() && deceased.hasNoGrandSonFromSon())
            return deceased.getLegacy() / 2;
        else if(deceased.hasManyGrandDaughterFromSon() && !deceased.hasoffspring() && deceased.hasNoGrandSonFromSon())
            grandDaughterPortion = (deceased.getLegacy() * 2) / (3 * noOfGrandDaughters);
        else if(deceased.hasOnlyOneDaughter() && deceased.hasNoSon() && deceased.hasNoGrandSonFromSon())
            grandDaughterPortion = (deceased.getLegacy() * 2) / (3 * noOfGrandDaughters);
        else if (deceased.hasOnlyOneDaughter() && deceased.hasNoSon() && !deceased.hasNoGrandSonFromSon()) {
            int noOfWives = 0;
            int noOfGrandSons = 0;

            double remainingportion = 0.0;
            for (Heir heir: theHeirs) {
                if (heir.isWife())
                    noOfWives++;
                else if (heir.isGrandSon()) {
                    noOfGrandSons++;
                }
            }

            if (!deceased.hasNoGrandSonFromSon()){

                List<Heir> unblockedheirs = new ArrayList<>();

                double husbandPortion = 0.0;
                double wifePortion = 0.0;
                double fatherPortion = 0.0;
                double motherPortion = 0.0;
                double grandfatherPortion = 0.0;
                double paternalGrandmotherPortion = 0.0;
                double maternalGrandmotherPortion = 0.0;
                double allFullBrotherPortion = 0.0;
                double allFullSisterPortion = 0.0;
                double allPaternalBrotherPortion = 0.0;
                double allPaternalSisterPortion = 0.0;
                double allMaternalBrotherPortion = 0.0;
                double allMaternalSisterPortion = 0.0;
                double allNephewPortion = 0.0;
                double allPaternalNephewPortion = 0.0;
                double allNephewSonPortion = 0.0;
                double allPaternalNephewSonPortion = 0.0;
                double allUnclePortion = 0.0;
                double allPaternalUnclePortion = 0.0;
                double allCousinPortion = 0.0;
                double allPaternalCousinPortion = 0.0;
                double allCousinSonPortion = 0.0;
                double allPaternalCousinSonPortion = 0.0;
                double allCousinGrandsonPortion = 0.0;
                double allPaternalCousinGrandsonPortion = 0.0;

                for (Heir heir: theHeirs) {

                    if (heir.isBlockable()){

                        BlockingRules.blockingRuleA(deceased);
                        BlockingRules.blockingRuleB(deceased);
                        BlockingRules.blockingRuleC(deceased);
                        BlockingRules.blockingRuleD(deceased);
                        BlockingRules.blockingRuleE(deceased);
                        BlockingRules.blockingRuleF(deceased);
                        BlockingRules.blockingRuleG(deceased);
                        BlockingRules.blockingRuleH(deceased);
                        BlockingRules.blockingRuleI(deceased);
                        BlockingRules.blockingRuleK(deceased);
                        BlockingRules.blockingRuleL(deceased);
                        BlockingRules.blockingRuleM(deceased);
                        BlockingRules.blockingRuleN(deceased);
                        BlockingRules.blockingRuleO(deceased);
                        BlockingRules.blockingRuleP(deceased);
                        BlockingRules.blockingRuleQ(deceased);
                        BlockingRules.blockingRuleR(deceased);
                        BlockingRules.blockingRuleS(deceased);
                        BlockingRules.blockingRuleT(deceased);
                    }

                    if (heir.isBlocked() == false){

                        if (heir.isHusband()){
                            double thehusbandportion = StandardRules.getHusbandportion(deceased);
                            husbandPortion += thehusbandportion;
                        }

                        else if (heir.isWife()){
                            double thewifeportion = StandardRules.getWifeportion(deceased , noOfWives);
                            husbandPortion += thewifeportion;
                        }
                        else if (heir.isFather()){
                            double thefatherportion = StandardRules.getFatherportion(deceased);
                            fatherPortion += thefatherportion;
                        }

                        else if (heir.isMother()){
                            double themotherportion = StandardRules.getMotherportion(deceased);
                            motherPortion += themotherportion;
                        }

                        else if (heir.isGrandFather()){
                            double thegrandfatherportion = StandardRules.getGrandFatherportion(deceased);
                            grandfatherPortion += thegrandfatherportion;
                        }

                        else if (heir.isPaternalGrandMother()){
                            double thepaternalgrandmotherportion = StandardRules.getPaternalGrandMotherportion(deceased);
                            paternalGrandmotherPortion += thepaternalgrandmotherportion;
                        }

                        else if(heir.isMaternalGrandMother())
                        {
                            double theMaternalGrandmotherPortion = StandardRules.getMaternalGrandMotherportion(deceased);
                            maternalGrandmotherPortion += theMaternalGrandmotherPortion;
                        }
                        else if(heir.isFullBrother())
                        {
                            double theFullBrotherportion = StandardRules.getFullBrotherportion(deceased);
                            allFullBrotherPortion += theFullBrotherportion;
                        }
                        else if(heir.isFullSister())
                        {
                            double theFullSisterPortion = StandardRules.getFullSisterportion(deceased);
                            allFullSisterPortion += theFullSisterPortion;
                        }

                        else if(heir.isMaternalBrother())
                        {
                            double theMaternalBrotherPortion = StandardRules.getMaternalSiblingportion(deceased);
                            allMaternalBrotherPortion += theMaternalBrotherPortion;
                        }
                        else if(heir.isMaternalSister())
                        {
                            double theMaternalSisterPortion = StandardRules.getMaternalSiblingportion(deceased);
                            allMaternalSisterPortion += theMaternalSisterPortion;
                        }
                        else if(heir.isNephew())
                        {
                            double thenephewportion = StandardRules.getNephewportion(deceased);
                            allNephewPortion += thenephewportion;
                        }
                        else if(heir.isPaternalNephew())
                        {
                            double thePaternalNephewportion = StandardRules.getPaternalNephewportion(deceased);
                            allPaternalNephewPortion += thePaternalNephewportion;
                        }
                        else if(heir.isNephewSon())
                        {
                            double theNephewSonportion = StandardRules.getNephewSonportion(deceased);
                            allNephewSonPortion += theNephewSonportion;
                        }
                        else if(heir.isPaternalNephewSon())
                        {
                            double thePaternaNephewSonportion = StandardRules.getPaternalNephewSonportion(deceased);
                            allPaternalNephewSonPortion += thePaternaNephewSonportion;
                        }
                        else if(heir.isUncle())
                        {
                            double theUncleportion = StandardRules.getUncleportion(deceased);
                            allUnclePortion += theUncleportion;
                        }
                        else if(heir.isPaternalUncle())
                        {
                            double thePaternalUncleportion = StandardRules.getPaternalUncleportion(deceased);
                            allPaternalUnclePortion += thePaternalUncleportion;
                        }
                        else if(heir.isCousin())
                        {
                            double theCousinportion = StandardRules.getCousinportion(deceased);
                            allCousinPortion += theCousinportion;
                        }
                        else if(heir.isCousinSon())
                        {
                            double theCousinSonportion = StandardRules.getCousinSonportion(deceased);
                            allCousinSonPortion += theCousinSonportion;
                        }
                        else if(heir.isPaternalCousinSon())
                        {
                            double thePaternalCousinSonportion = StandardRules.getPaternalCousinSonportion(deceased);
                            allPaternalCousinSonPortion += thePaternalCousinSonportion;
                        }
                        else if(heir.isCousinGrandson())
                        {
                            double theCousinGrandsonportion = StandardRules.getCousinGrandsonportion(deceased);
                            allCousinGrandsonPortion += theCousinGrandsonportion;
                        }
                        else if(heir.isPaternalCousinGrandson())
                        {
                            double thePaternalCousinGrandsonportion = StandardRules.getPaternalCousinGrandsonportion(deceased);
                            allPaternalCousinGrandsonPortion += thePaternalCousinGrandsonportion;
                        }
                        unblockedheirs.add(heir);
                    }
                }

                if(deceased.getGender().equals(Person.MALE)) {

                    //we devide the legacy on the prescribed heirs first
                    remainingportion = deceased.getLegacy() - (wifePortion + fatherPortion
                            + motherPortion + grandfatherPortion + paternalGrandmotherPortion + maternalGrandmotherPortion
                            + allFullBrotherPortion + allFullSisterPortion + allPaternalBrotherPortion
                            + allPaternalSisterPortion + allMaternalBrotherPortion + allMaternalSisterPortion
                            + allNephewPortion + allPaternalNephewPortion + allNephewSonPortion + allPaternalNephewSonPortion
                            + allUnclePortion + allPaternalUnclePortion + allCousinPortion + allPaternalCousinPortion
                            + allCousinSonPortion + allPaternalCousinSonPortion + allCousinGrandsonPortion
                            + allPaternalCousinGrandsonPortion);

                    grandDaughterPortion = remainingportion / (noOfGrandDaughters + (noOfGrandSons * 2));

                }
                else if(deceased.getGender().equals(Person.FEMALE)) {

                    //we devide the legacy on the prescribed heirs first
                    remainingportion = deceased.getLegacy() - (husbandPortion + fatherPortion
                            + motherPortion + grandfatherPortion + paternalGrandmotherPortion + maternalGrandmotherPortion
                            + allFullBrotherPortion + allFullSisterPortion + allPaternalBrotherPortion
                            + allPaternalSisterPortion + allMaternalBrotherPortion + allMaternalSisterPortion
                            + allNephewPortion + allPaternalNephewPortion + allNephewSonPortion + allPaternalNephewSonPortion
                            + allUnclePortion + allPaternalUnclePortion + allCousinPortion + allPaternalCousinPortion
                            + allCousinSonPortion + allPaternalCousinSonPortion + allCousinGrandsonPortion
                            + allPaternalCousinGrandsonPortion);

                    grandDaughterPortion = remainingportion / (noOfGrandDaughters + (noOfGrandSons * 2));

                }

            }
        }
        return grandDaughterPortion;
    }

    private static double getPaternalCousinGrandsonportion(Deceased deceased) {

        double paternalcousingrandsonportion = 0.0;
        double remainingportion = 0.0;

        int noOfWives = 0;
        int noOfPaternalCousinGrandson = 0;

        List<Heir> theheirs = deceased.getHeirs();

        for (Heir heir: theheirs) {
            if (heir.isWife()) {
                noOfWives++;
            }
            else if (heir.isPaternalCousinGrandson()){
                noOfPaternalCousinGrandson++;
            }
        }




        if (!deceased.hasPaternalCousinSon() && !deceased.hasCousinSon() && !deceased.hasPaternalCousin() && !deceased.hasCousin() && !deceased.hasPaternalUncle()
                && !deceased.hasUncle() && !deceased.hasPaternalNephew() && !deceased.hasNephew() && deceased.hasNoPaternalBrother() && deceased.hasNoFullBrother() && !deceased.hasGrandFather() && !deceased.hasFather() && !deceased.hasGrandSonFromSon() && !deceased.hasSon()){

            List<Heir> unblockedheirs = new ArrayList<>();

            double husbandportion = 0.0;
            double wifeportion = 0.0;
            double motherportion = 0.0;


            for (Heir heir : theheirs){

                if (heir.isHusband()){
                    double thehusbandportion = StandardRules.getHusbandportion(deceased);
                    husbandportion += thehusbandportion;
                } else if (heir.isWife()) {
                    double thewifeportion = StandardRules.getWifeportion(deceased, noOfWives);
                    wifeportion += thewifeportion;
                } else if (heir.isMother()) {
                    double themotherportion = StandardRules.getMotherportion(deceased);
                    motherportion += themotherportion;
                }
                unblockedheirs.add(heir);
            }

            if (deceased.getGender().equals(Person.MALE)){
                remainingportion = deceased.getLegacy() - (wifeportion + motherportion);
            } else if (deceased.getGender().equals(Person.FEMALE)) {
                remainingportion = deceased.getLegacy() - (husbandportion + motherportion);
            }

            paternalcousingrandsonportion = remainingportion / noOfPaternalCousinGrandson;

        }


        return paternalcousingrandsonportion;
    }

    private static double getCousinGrandsonportion(Deceased deceased) {
        double cousingrandsonportion = 0.0;
        double remainingportion = 0.0;

        int noOfWives = 0;
        int noOfCousinGrandson = 0;

        List<Heir> theheirs = deceased.getHeirs();

        for (Heir heir: theheirs) {
            if (heir.isWife()) {
                noOfWives++;
            }
            else if (heir.isCousinGrandson()){
                noOfCousinGrandson++;
            }
        }




        if (!deceased.hasCousinSon() && !deceased.hasPaternalCousin() && !deceased.hasCousin() && !deceased.hasPaternalUncle()
                && !deceased.hasUncle() && !deceased.hasPaternalNephew() && !deceased.hasNephew() && deceased.hasNoPaternalBrother() && deceased.hasNoFullBrother() && !deceased.hasGrandFather() && !deceased.hasFather() && !deceased.hasGrandSonFromSon() && !deceased.hasSon()){

            List<Heir> unblockedheirs = new ArrayList<>();

            double husbandportion = 0.0;
            double wifeportion = 0.0;
            double motherportion = 0.0;


            for (Heir heir : theheirs){

                if (heir.isHusband()){
                    double thehusbandportion = StandardRules.getHusbandportion(deceased);
                    husbandportion += thehusbandportion;
                } else if (heir.isWife()) {
                    double thewifeportion = StandardRules.getWifeportion(deceased, noOfWives);
                    wifeportion += thewifeportion;
                } else if (heir.isMother()) {
                    double themotherportion = StandardRules.getMotherportion(deceased);
                    motherportion += themotherportion;
                }
                unblockedheirs.add(heir);
            }

            if (deceased.getGender().equals(Person.MALE)){
                remainingportion = deceased.getLegacy() - (wifeportion + motherportion);
            } else if (deceased.getGender().equals(Person.FEMALE)) {
                remainingportion = deceased.getLegacy() - (husbandportion + motherportion);
            }

            cousingrandsonportion = remainingportion / noOfCousinGrandson ;

        }


        return cousingrandsonportion;
    }

    private static double getPaternalCousinSonportion(Deceased deceased) {
        double paternalcousinsonportion = 0.0;
        double remainingportion = 0.0;

        int noOfWives = 0;
        int noOfPaternalCousinson = 0;

        List<Heir> theheirs = deceased.getHeirs();

        for (Heir heir: theheirs) {
            if (heir.isWife()) {
                noOfWives++;
            }
            else if (heir.isPaternalCousinGrandson()){
                noOfPaternalCousinson++;
            }
        }




        if (!deceased.hasPaternalCousin() && !deceased.hasCousin() && !deceased.hasPaternalUncle() && !deceased.hasUncle() && !deceased.hasPaternalNephew()
                && !deceased.hasNephew() && deceased.hasNoPaternalBrother() && deceased.hasNoFullBrother() && !deceased.hasGrandFather() && !deceased.hasFather() && !deceased.hasGrandSonFromSon() && !deceased.hasSon()){

            List<Heir> unblockedheirs = new ArrayList<>();

            double husbandportion = 0.0;
            double wifeportion = 0.0;
            double motherportion = 0.0;


            for (Heir heir : theheirs){

                if (heir.isHusband()){
                    double thehusbandportion = StandardRules.getHusbandportion(deceased);
                    husbandportion += thehusbandportion;
                } else if (heir.isWife()) {
                    double thewifeportion = StandardRules.getWifeportion(deceased, noOfWives);
                    wifeportion += thewifeportion;
                } else if (heir.isMother()) {
                    double themotherportion = StandardRules.getMotherportion(deceased);
                    motherportion += themotherportion;
                }
                unblockedheirs.add(heir);
            }

            if (deceased.getGender().equals(Person.MALE)){
                remainingportion = deceased.getLegacy() - (wifeportion + motherportion);
            } else if (deceased.getGender().equals(Person.FEMALE)) {
                remainingportion = deceased.getLegacy() - (husbandportion + motherportion);
            }

            paternalcousinsonportion = remainingportion / noOfPaternalCousinson;

        }


        return paternalcousinsonportion;
    }

    private static double getCousinSonportion(Deceased deceased) {
        double cousinsonportion = 0.0;
        double remainingportion = 0.0;

        int noOfWives = 0;
        int noOfCousinson = 0;

        List<Heir> theheirs = deceased.getHeirs();

        for (Heir heir: theheirs) {
            if (heir.isWife()) {
                noOfWives++;
            }
            else if (heir.isCousinSon()){
                noOfCousinson++;
            }
        }




        if (!deceased.hasCousin() && !deceased.hasPaternalUncle() && !deceased.hasUncle() && !deceased.hasPaternalNephew() && !deceased.hasNephew()
                && deceased.hasNoPaternalBrother() && deceased.hasNoFullBrother() && !deceased.hasGrandFather() && !deceased.hasFather() && !deceased.hasGrandSonFromSon() && !deceased.hasSon()){

            List<Heir> unblockedheirs = new ArrayList<>();

            double husbandportion = 0.0;
            double wifeportion = 0.0;
            double motherportion = 0.0;


            for (Heir heir : theheirs){

                if (heir.isHusband()){
                    double thehusbandportion = StandardRules.getHusbandportion(deceased);
                    husbandportion += thehusbandportion;
                } else if (heir.isWife()) {
                    double thewifeportion = StandardRules.getWifeportion(deceased, noOfWives);
                    wifeportion += thewifeportion;
                } else if (heir.isMother()) {
                    double themotherportion = StandardRules.getMotherportion(deceased);
                    motherportion += themotherportion;
                }
                unblockedheirs.add(heir);
            }

            if (deceased.getGender().equals(Person.MALE)){
                remainingportion = deceased.getLegacy() - (wifeportion + motherportion);
            } else if (deceased.getGender().equals(Person.FEMALE)) {
                remainingportion = deceased.getLegacy() - (husbandportion + motherportion);
            }

            cousinsonportion = remainingportion / noOfCousinson;

        }


        return cousinsonportion;
    }

    private static double getCousinportion(Deceased deceased) {

        double cousinportion = 0.0;
        double remainingportion = 0.0;

        int noOfWives = 0;
        int noOfCousin = 0;

        List<Heir> theheirs = deceased.getHeirs();

        for (Heir heir: theheirs) {
            if (heir.isWife()) {
                noOfWives++;
            }
            else if (heir.isCousin()){
                noOfCousin++;
            }
        }

        if (!deceased.hasPaternalUncle() && !deceased.hasUncle() && !deceased.hasPaternalNephew() && !deceased.hasNephew() && deceased.hasNoPaternalBrother()
                && deceased.hasNoFullBrother() && !deceased.hasGrandFather() && !deceased.hasFather() && !deceased.hasGrandSonFromSon() && !deceased.hasSon()){
            List<Heir> unblockedheirs = new ArrayList<>();

            double husbandportion = 0.0;
            double wifeportion = 0.0;
            double motherportion = 0.0;


            for (Heir heir : theheirs){

                if (heir.isHusband()){
                    double thehusbandportion = StandardRules.getHusbandportion(deceased);
                    husbandportion += thehusbandportion;
                } else if (heir.isWife()) {
                    double thewifeportion = StandardRules.getWifeportion(deceased, noOfWives);
                    wifeportion += thewifeportion;
                } else if (heir.isMother()) {
                    double themotherportion = StandardRules.getMotherportion(deceased);
                    motherportion += themotherportion;
                }
                unblockedheirs.add(heir);
            }
            if (deceased.getGender().equals(Person.MALE)){
                remainingportion = deceased.getLegacy() - (wifeportion + motherportion);
            } else if (deceased.getGender().equals(Person.FEMALE)) {
                remainingportion = deceased.getLegacy() - (husbandportion + motherportion);
            }

            cousinportion = remainingportion / noOfCousin;
        }

        return cousinportion;

    }

    private static double getPaternalUncleportion(Deceased deceased) {
        //begin
        double paternaluncleportion = 0.0;
        double remainingportion = 0.0;

        int noOfWives = 0;
        int noOfpaternaluncles = 0;

        List<Heir> theheirs = deceased.getHeirs();

        for (Heir heir: theheirs) {
            if (heir.isWife()) {
                noOfWives++;
            }
            else if (heir.isPaternalUncle()){
                noOfpaternaluncles++;
            }
        }

        if (!deceased.hasUncle() && !deceased.hasPaternalNephew() && !deceased.hasNephew() && deceased.hasNoPaternalBrother()
                && deceased.hasNoFullBrother() && !deceased.hasGrandFather() && !deceased.hasFather() && !deceased.hasGrandSonFromSon() && !deceased.hasSon()){

            List<Heir> unblockedheirs = new ArrayList<>();

            double husbandportion = 0.0;
            double wifeportion = 0.0;
            double motherportion = 0.0;

            for (Heir heir: theheirs) {
                if (heir.isHusband()){
                    double thehusbandportion = StandardRules.getHusbandportion(deceased);
                    husbandportion += thehusbandportion;
                } else if (heir.isWife()) {
                    double thewifeportion = StandardRules.getWifeportion(deceased, noOfWives);
                    wifeportion += thewifeportion;
                } else if (heir.isMother()) {
                    double themotherportion = StandardRules.getMotherportion(deceased);
                    motherportion += themotherportion;
                }
                unblockedheirs.add(heir);
            }
            if (deceased.getGender().equals(Person.MALE)){
                remainingportion = deceased.getLegacy() - (wifeportion + motherportion);
            } else if (deceased.getGender().equals(Person.FEMALE)) {
                remainingportion = deceased.getLegacy() - (husbandportion + motherportion);
            }

            paternaluncleportion = remainingportion / noOfpaternaluncles;

        }

        return paternaluncleportion;
        //end
    }

    private static double getUncleportion(Deceased deceased) {
        //begin
        double uncleportion = 0.0;
        double remainingportion = 0.0;

        int noOfWives = 0;
        int noOfUncles = 0;

        List<Heir> theheirs = deceased.getHeirs();

        for (Heir heir: theheirs) {
            if (heir.isWife()) {
                noOfWives++;
            }
            else if (heir.isUncle()){
                noOfUncles++;
            }
        }

        if (!deceased.hasPaternalNephew() && !deceased.hasNephew() && deceased.hasNoPaternalBrother() && deceased.hasNoFullBrother()
                && !deceased.hasGrandFather() && !deceased.hasFather() && !deceased.hasGrandSonFromSon() && !deceased.hasSon()){

            List<Heir> unblockedheairs = new ArrayList<>();

            double husbandportion = 0.0;
            double wifeportion = 0.0;
            double motherportion = 0.0;

            for (Heir heir: theheirs) {

                if (heir.isHusband()){
                    double thehusbandportion = StandardRules.getHusbandportion(deceased);
                    husbandportion += thehusbandportion;
                } else if (heir.isWife()) {
                    double thewifeportion = StandardRules.getWifeportion(deceased, noOfWives);
                    wifeportion += thewifeportion;
                } else if (heir.isMother()) {
                    double themotherportion = StandardRules.getMotherportion(deceased);
                    motherportion += themotherportion;
                }
                unblockedheairs.add(heir);

            }
            if (deceased.getGender().equals(Person.MALE)){
                remainingportion = deceased.getLegacy() - (wifeportion + motherportion);
            } else if (deceased.getGender().equals(Person.FEMALE)) {
                remainingportion = deceased.getLegacy() - (husbandportion + motherportion);
            }

            uncleportion = remainingportion / noOfUncles;

        }

        return uncleportion;
        //end
    }

    private static double getPaternalNephewSonportion(Deceased deceased) {
        //begin
        double paternalnephewsonportion = 0.0;
        double remainingportion = 0.0;

        int noOfWives = 0;
        int noOfPaternalNephewSon = 0;

        List<Heir> theheirs = deceased.getHeirs();

        for (Heir heir: theheirs) {

            if (heir.isWife())
                noOfWives++;
            else if (heir.isPaternalNephewSon())
                noOfPaternalNephewSon++;
        }

        if (!deceased.hasPaternalNephew() && !deceased.hasNephew() && deceased.hasNoPaternalBrother() && deceased.hasNoFullBrother()
                && !deceased.hasGrandFather() && !deceased.hasFather() && !deceased.hasGrandSonFromSon() && !deceased.hasSon()){

            List<Heir> unblockedheairs = new ArrayList<>();

            double husbandportion = 0.0;
            double wifeportion = 0.0;
            double motherportion = 0.0;

            for (Heir heir: theheirs) {
                if (heir.isHusband()){
                    double thehusbandportion = StandardRules.getHusbandportion(deceased);
                    husbandportion += thehusbandportion;
                } else if (heir.isWife()) {
                    double thewifeportion = StandardRules.getWifeportion(deceased, noOfWives);
                    wifeportion += thewifeportion;
                } else if (heir.isMother()) {
                    double themotherportion = StandardRules.getMotherportion(deceased);
                    motherportion += themotherportion;
                }
                unblockedheairs.add(heir);
            }

            if (deceased.getGender().equals(Person.MALE)){
                remainingportion = deceased.getLegacy() - (wifeportion + motherportion);
            } else if (deceased.getGender().equals(Person.FEMALE)) {
                remainingportion = deceased.getLegacy() - (husbandportion + motherportion);
            }

            paternalnephewsonportion = remainingportion / noOfPaternalNephewSon;

        }

        return paternalnephewsonportion;

        //end
    }

    private static double getNephewSonportion(Deceased deceased) {
        //begin

        double nephewsonportion = 0.0;
        double remainingportion = 0.0;

        int noOfNephewSon = 0;
        int noOfWives = 0;

        List<Heir> theheirs = deceased.getHeirs();

        for (Heir heir: theheirs) {
            if (heir.isWife())
                noOfWives++;
            else if (heir.isNephewSon())
                noOfNephewSon++;
        }

        if (!deceased.hasNephew() && deceased.hasNoPaternalBrother() && deceased.hasNoFullBrother() && !deceased.hasGrandFather()
                && !deceased.hasFather() && !deceased.hasGrandSonFromSon() && !deceased.hasSon()){

            List<Heir> unblockedheairs = new ArrayList<>();

            double husbandportion = 0.0;
            double wifeportion = 0.0;
            double motherportion = 0.0;

            for (Heir heir: theheirs) {
                if (heir.isHusband()){
                    double thehusbandportion = StandardRules.getHusbandportion(deceased);
                    husbandportion += thehusbandportion;
                } else if (heir.isWife()) {
                    double thewifeportion = StandardRules.getWifeportion(deceased, noOfWives);
                    wifeportion += thewifeportion;
                } else if (heir.isMother()) {
                    double themotherportion = StandardRules.getMotherportion(deceased);
                    motherportion += themotherportion;
                }
                unblockedheairs.add(heir);
            }
            if (deceased.getGender().equals(Person.MALE)){
                remainingportion = deceased.getLegacy() - (wifeportion + motherportion);
            } else if (deceased.getGender().equals(Person.FEMALE)) {
                remainingportion = deceased.getLegacy() - (husbandportion + motherportion);
            }

            nephewsonportion = remainingportion / noOfNephewSon;

        }

        return nephewsonportion;

        //end
    }

    private static double getPaternalNephewportion(Deceased deceased) {
        //begin

        double paternalnephewportion = 0.0;
        double remainingportion = 0.0;

        int noOfWives = 0;
        int noOfPaternalNephews = 0;

        List<Heir> theheirs = deceased.getHeirs();

        for (Heir heir: theheirs) {
            if (heir.isWife())
                noOfWives++;
            else if (heir.isPaternalNephew())
                noOfPaternalNephews++;
        }

        if (!deceased.hasNephewSon() && !deceased.hasNephew() && deceased.hasNoPaternalBrother() && deceased.hasNoFullBrother()
                && !deceased.hasGrandFather() && !deceased.hasFather() && !deceased.hasGrandSonFromSon() && !deceased.hasSon()){

            List<Heir> unblockedheirs = new ArrayList<>();

            double husbandportion = 0.0;
            double wifeportion = 0.0;
            double motherportion = 0.0;

            for (Heir heir: theheirs){
                if (heir.isHusband()){
                    double thehusbandportion = StandardRules.getHusbandportion(deceased);
                    husbandportion += thehusbandportion;
                } else if (heir.isWife()) {
                    double thewifeportion = StandardRules.getWifeportion(deceased, noOfWives);
                    wifeportion += thewifeportion;
                } else if (heir.isMother()) {
                    double themotherportion = StandardRules.getMotherportion(deceased);
                    motherportion += themotherportion;
                }
                unblockedheirs.add(heir);
            }
            if (deceased.getGender().equals(Person.MALE)){
                remainingportion = deceased.getLegacy() - (wifeportion + motherportion);
            } else if (deceased.getGender().equals(Person.FEMALE)) {
                remainingportion = deceased.getLegacy() - (husbandportion + motherportion);
            }
            paternalnephewportion = remainingportion / noOfPaternalNephews;
        }
        return paternalnephewportion;

        //end
    }

    private static double getNephewportion(Deceased deceased) {
        //begin

        double nephewportion = 0.0;
        double remainingportion = 0.0;

        List<Heir> theheirs = deceased.getHeirs();

        int noOfWives = 0;
        int noOfNephews = 0;

        for (Heir heir: theheirs) {
            if (heir.isWife())
                noOfWives++;
            else if (heir.isNephew())
                noOfNephews++;
        }

        if (deceased.hasNoPaternalBrother() && deceased.hasNoFullBrother()
                && !deceased.hasGrandFather() && !deceased.hasFather() && !deceased.hasGrandSonFromSon() && !deceased.hasSon()){

            double husbandportion = 0.0;
            double wifeportion = 0.0;
            double motherportion = 0.0;

            List<Heir> unblockedhairs = new ArrayList<>();

            for (Heir heir: theheirs) {
                if (heir.isHusband()){
                    double thehusbandportion = StandardRules.getHusbandportion(deceased);
                    husbandportion += thehusbandportion;
                } else if (heir.isWife()) {
                    double thewifeportion = StandardRules.getWifeportion(deceased, noOfWives);
                    wifeportion += thewifeportion;
                } else if (heir.isMother()) {
                    double themotherportion = StandardRules.getMotherportion(deceased);
                    motherportion += themotherportion;
                }
                unblockedhairs.add(heir);
            }
            if (deceased.getGender().equals(Person.MALE)){
                remainingportion = deceased.getLegacy() - (wifeportion + motherportion);
            } else if (deceased.getGender().equals(Person.FEMALE)) {
                remainingportion = deceased.getLegacy() - (husbandportion + motherportion);
            }

            nephewportion = remainingportion / noOfNephews;
        }

        return nephewportion;
        //end
    }

    private static double getMaternalSiblingportion(Deceased deceased) {
        int noOfMaternalSibling = 0;
        double maternalSisterPortion = 0.0;
        List<Heir> theHeirs = deceased.getHeirs();
        for(Heir theHeir : theHeirs)
        {
            if(theHeir.isMaternalBrother() || theHeir.isMaternalSister())
                ++noOfMaternalSibling;
        }
        if(deceased.hasOnlyOneMaternalSibling() && deceased.hasNoSon() && deceased.hasNoMalePaternalAncestor())
            maternalSisterPortion = deceased.getLegacy() / 6;
        else if(deceased.hasManyMaternalSibling() && deceased.hasNoSon() && deceased.hasNoMalePaternalAncestor())
            maternalSisterPortion = deceased.getLegacy() / (3 * noOfMaternalSibling);
        else if(deceased.hasOnlyOneFullSister() && !deceased.hasoffspring() && deceased.hasNoMalePaternalAncestor() && deceased.hasNoFullBrother() && deceased.hasNoPaternalBrother())
            maternalSisterPortion = deceased.getLegacy() / 6;
        return maternalSisterPortion;

    }

    private static double getPaternalSisterportion(Deceased deceased) {
        int noOfPaternalSisters = 0;
        double paternalSisterPortion = 0.0;
        List<Heir> theHeirs = deceased.getHeirs();
        for(Heir theHeir : theHeirs)
        {
            if(theHeir.isPaternalSister())
                ++noOfPaternalSisters;
        }
        if(deceased.hasOnlyOnePaternalSister() && !deceased.hasoffspring() && deceased.hasNoMalePaternalAncestor() && deceased.hasNoFullSiblingOrPaternalBrother())
            paternalSisterPortion = deceased.getLegacy() / 2;
        else if(deceased.hasMultiplePaternalSisters() && !deceased.hasoffspring() && deceased.hasNoMalePaternalAncestor() && deceased.hasNoFullSiblingOrPaternalBrother())
            paternalSisterPortion = deceased.getLegacy() * 2 / (3 * noOfPaternalSisters);
        else if(deceased.hasOnlyOneFullSister() && !deceased.hasoffspring() && deceased.hasNoMalePaternalAncestor() && deceased.hasNoFullBrother() && deceased.hasNoPaternalBrother())
            paternalSisterPortion = deceased.getLegacy() / 6;
        else if (!deceased.hasNoPaternalBrother() && !deceased.hasoffspring() && deceased.hasNoMalePaternalAncestor() && deceased.hasNoFullBrother()) {
            int noOfWives = 0;
            int noOfPaternalBrothers = 0;

            double remainingportion = 0.0;

            for (Heir heir: theHeirs) {
                if (heir.isPaternalBrother())
                    noOfPaternalBrothers++;
                else if (heir.isWife()) {
                    noOfWives++;
                }
            }

            List<Heir> unblockedheirs = new ArrayList<>();

            double husbandPortion = 0.0;
            double wifePortion = 0.0;
            double allGrandsonPortion = 0.0;
            double allGranddaughterPortion = 0.0;
            double fatherPortion = 0.0;
            double motherPortion = 0.0;
            double grandfatherPortion = 0.0;
            double paternalGrandmotherPortion = 0.0;
            double maternalGrandmotherPortion = 0.0;
            double allFullBrotherPortion = 0.0;
            double allFullSisterPortion = 0.0;
            double allMaternalBrotherPortion = 0.0;
            double allMaternalSisterPortion = 0.0;
            double allNephewPortion = 0.0;
            double allPaternalNephewPortion = 0.0;
            double allNephewSonPortion = 0.0;
            double allPaternalNephewSonPortion = 0.0;
            double allUnclePortion = 0.0;
            double allPaternalUnclePortion = 0.0;
            double allCousinPortion = 0.0;
            double allPaternalCousinPortion = 0.0;
            double allCousinSonPortion = 0.0;
            double allPaternalCousinSonPortion = 0.0;
            double allCousinGrandsonPortion = 0.0;
            double allPaternalCousinGrandsonPortion = 0.0;

            for (Heir heir: theHeirs) {

                if (heir.isBlockable()){

                    BlockingRules.blockingRuleA(deceased);
                    BlockingRules.blockingRuleB(deceased);
                    BlockingRules.blockingRuleC(deceased);
                    BlockingRules.blockingRuleD(deceased);
                    BlockingRules.blockingRuleE(deceased);
                    BlockingRules.blockingRuleF(deceased);
                    BlockingRules.blockingRuleG(deceased);
                    BlockingRules.blockingRuleH(deceased);
                    BlockingRules.blockingRuleI(deceased);
                    BlockingRules.blockingRuleK(deceased);
                    BlockingRules.blockingRuleL(deceased);
                    BlockingRules.blockingRuleM(deceased);
                    BlockingRules.blockingRuleN(deceased);
                    BlockingRules.blockingRuleO(deceased);
                    BlockingRules.blockingRuleP(deceased);
                    BlockingRules.blockingRuleQ(deceased);
                    BlockingRules.blockingRuleR(deceased);
                    BlockingRules.blockingRuleS(deceased);
                    BlockingRules.blockingRuleT(deceased);
                }

                if (heir.isBlocked() == false){
                    if (heir.isHusband()){
                        double thehusbandportion = StandardRules.getHusbandportion(deceased);
                        husbandPortion += thehusbandportion;
                    }

                    else if (heir.isWife()){
                        double thewifeportion = StandardRules.getWifeportion(deceased , noOfWives);
                        husbandPortion += thewifeportion;
                    }

                    else if (heir.isGrandSon()){
                        double thegrandsonportion = StandardRules.getGrandsonportion(deceased);
                        allGrandsonPortion += thegrandsonportion;
                    }

                    else if (heir.isGrandDaughter()){
                        double thegranddaughterportion = StandardRules.getGrandDaughterportion(deceased);
                        allGranddaughterPortion += thegranddaughterportion;
                    }

                    else if (heir.isFather()){
                        double thefatherportion = StandardRules.getFatherportion(deceased);
                        fatherPortion += thefatherportion;
                    }

                    else if (heir.isMother()){
                        double themotherportion = StandardRules.getMotherportion(deceased);
                        motherPortion += themotherportion;
                    }

                    else if (heir.isGrandFather()){
                        double thegrandfatherportion = StandardRules.getGrandFatherportion(deceased);
                        grandfatherPortion += thegrandfatherportion;
                    }

                    else if (heir.isPaternalGrandMother()){
                        double thepaternalgrandmotherportion = StandardRules.getPaternalGrandMotherportion(deceased);
                        paternalGrandmotherPortion += thepaternalgrandmotherportion;
                    }

                    else if(heir.isMaternalGrandMother())
                    {
                        double theMaternalGrandmotherPortion = StandardRules.getMaternalGrandMotherportion(deceased);
                        maternalGrandmotherPortion += theMaternalGrandmotherPortion;
                    }
                    else if(heir.isFullBrother())
                    {
                        double theFullBrotherportion = StandardRules.getFullBrotherportion(deceased);
                        allFullBrotherPortion += theFullBrotherportion;
                    }
                    else if(heir.isFullSister())
                    {
                        double theFullSisterPortion = StandardRules.getFullSisterportion(deceased);
                        allFullSisterPortion += theFullSisterPortion;
                    }
                    else if(heir.isMaternalBrother())
                    {
                        double theMaternalBrotherPortion = StandardRules.getMaternalSiblingportion(deceased);
                        allMaternalBrotherPortion += theMaternalBrotherPortion;
                    }
                    else if(heir.isMaternalSister())
                    {
                        double theMaternalSisterPortion = StandardRules.getMaternalSiblingportion(deceased);
                        allMaternalSisterPortion += theMaternalSisterPortion;
                    }
                    else if(heir.isNephew())
                    {
                        double thenephewportion = StandardRules.getNephewportion(deceased);
                        allNephewPortion += thenephewportion;
                    }
                    else if(heir.isPaternalNephew())
                    {
                        double thePaternalNephewportion = StandardRules.getPaternalNephewportion(deceased);
                        allPaternalNephewPortion += thePaternalNephewportion;
                    }
                    else if(heir.isNephewSon())
                    {
                        double theNephewSonportion = StandardRules.getNephewSonportion(deceased);
                        allNephewSonPortion += theNephewSonportion;
                    }
                    else if(heir.isPaternalNephewSon())
                    {
                        double thePaternaNephewSonportion = StandardRules.getPaternalNephewSonportion(deceased);
                        allPaternalNephewSonPortion += thePaternaNephewSonportion;
                    }
                    else if(heir.isUncle())
                    {
                        double theUncleportion = StandardRules.getUncleportion(deceased);
                        allUnclePortion += theUncleportion;
                    }
                    else if(heir.isPaternalUncle())
                    {
                        double thePaternalUncleportion = StandardRules.getPaternalUncleportion(deceased);
                        allPaternalUnclePortion += thePaternalUncleportion;
                    }
                    else if(heir.isCousin())
                    {
                        double theCousinportion = StandardRules.getCousinportion(deceased);
                        allCousinPortion += theCousinportion;
                    }
                    else if(heir.isCousinSon())
                    {
                        double theCousinSonportion = StandardRules.getCousinSonportion(deceased);
                        allCousinSonPortion += theCousinSonportion;
                    }
                    else if(heir.isPaternalCousinSon())
                    {
                        double thePaternalCousinSonportion = StandardRules.getPaternalCousinSonportion(deceased);
                        allPaternalCousinSonPortion += thePaternalCousinSonportion;
                    }
                    else if(heir.isCousinGrandson())
                    {
                        double theCousinGrandsonportion = StandardRules.getCousinGrandsonportion(deceased);
                        allCousinGrandsonPortion += theCousinGrandsonportion;
                    }
                    else if(heir.isPaternalCousinGrandson())
                    {
                        double thePaternalCousinGrandsonportion = StandardRules.getPaternalCousinGrandsonportion(deceased);
                        allPaternalCousinGrandsonPortion += thePaternalCousinGrandsonportion;
                    }
                    unblockedheirs.add(heir);
                }

            }
            if(deceased.getGender().equals(Person.MALE)) {

                remainingportion = deceased.getLegacy() - (wifePortion + allGrandsonPortion + allGranddaughterPortion + fatherPortion
                        + motherPortion + grandfatherPortion + paternalGrandmotherPortion + maternalGrandmotherPortion
                        + allFullBrotherPortion + allFullSisterPortion + allMaternalBrotherPortion + allMaternalSisterPortion
                        + allNephewPortion + allPaternalNephewPortion + allNephewSonPortion + allPaternalNephewSonPortion
                        + allUnclePortion + allPaternalUnclePortion + allCousinPortion + allPaternalCousinPortion
                        + allCousinSonPortion + allPaternalCousinSonPortion + allCousinGrandsonPortion
                        + allPaternalCousinGrandsonPortion);

                paternalSisterPortion = remainingportion / (noOfPaternalSisters + (noOfPaternalBrothers * 2));
            }
            else if(deceased.getGender().equals(Person.FEMALE)) {

                remainingportion = deceased.getLegacy() - (husbandPortion + allGrandsonPortion + allGranddaughterPortion + fatherPortion
                        + motherPortion + grandfatherPortion + paternalGrandmotherPortion + maternalGrandmotherPortion
                        + allFullBrotherPortion + allFullSisterPortion + allMaternalBrotherPortion + allMaternalSisterPortion
                        + allNephewPortion + allPaternalNephewPortion + allNephewSonPortion + allPaternalNephewSonPortion
                        + allUnclePortion + allPaternalUnclePortion + allCousinPortion + allPaternalCousinPortion
                        + allCousinSonPortion + allPaternalCousinSonPortion + allCousinGrandsonPortion
                        + allPaternalCousinGrandsonPortion);

                paternalSisterPortion = remainingportion / (noOfPaternalSisters + (noOfPaternalBrothers * 2));
            }
        }
        return paternalSisterPortion;
    }

    private static double getPaternalBrotherportion(Deceased deceased) {
        //begin
        int noOfWives = 0;
        int noOfPaternalBrothers = 0;
        int noOfPaternalSisters = 0;

        double paternalSisterPortion = 0.0;
        double paternaBrotherportion = 0.0;
        double remainingportion = 0.0;

        List<Heir> theHeirs = deceased.getHeirs();

        for (Heir heir: theHeirs) {
            if (heir.isPaternalBrother())
                noOfPaternalBrothers++;
            else if (heir.isWife()) {
                noOfWives++;
            } else if (heir.isPaternalSister()) {
                noOfPaternalSisters++;
            }
        }
        if (!deceased.hasNoPaternalBrother()) {

            List<Heir> unblockedheirs = new ArrayList<>();

            double husbandPortion = 0.0;
            double wifePortion = 0.0;
            double allGrandsonPortion = 0.0;
            double allGranddaughterPortion = 0.0;
            double fatherPortion = 0.0;
            double motherPortion = 0.0;
            double grandfatherPortion = 0.0;
            double paternalGrandmotherPortion = 0.0;
            double maternalGrandmotherPortion = 0.0;
            double allFullBrotherPortion = 0.0;
            double allFullSisterPortion = 0.0;
            double allMaternalBrotherPortion = 0.0;
            double allMaternalSisterPortion = 0.0;
            double allNephewPortion = 0.0;
            double allPaternalNephewPortion = 0.0;
            double allNephewSonPortion = 0.0;
            double allPaternalNephewSonPortion = 0.0;
            double allUnclePortion = 0.0;
            double allPaternalUnclePortion = 0.0;
            double allCousinPortion = 0.0;
            double allPaternalCousinPortion = 0.0;
            double allCousinSonPortion = 0.0;
            double allPaternalCousinSonPortion = 0.0;
            double allCousinGrandsonPortion = 0.0;
            double allPaternalCousinGrandsonPortion = 0.0;

            for (Heir heir : theHeirs) {

                if (heir.isBlockable()) {

                    BlockingRules.blockingRuleA(deceased);
                    BlockingRules.blockingRuleB(deceased);
                    BlockingRules.blockingRuleC(deceased);
                    BlockingRules.blockingRuleD(deceased);
                    BlockingRules.blockingRuleE(deceased);
                    BlockingRules.blockingRuleF(deceased);
                    BlockingRules.blockingRuleG(deceased);
                    BlockingRules.blockingRuleH(deceased);
                    BlockingRules.blockingRuleI(deceased);
                    BlockingRules.blockingRuleK(deceased);
                    BlockingRules.blockingRuleL(deceased);
                    BlockingRules.blockingRuleM(deceased);
                    BlockingRules.blockingRuleN(deceased);
                    BlockingRules.blockingRuleO(deceased);
                    BlockingRules.blockingRuleP(deceased);
                    BlockingRules.blockingRuleQ(deceased);
                    BlockingRules.blockingRuleR(deceased);
                    BlockingRules.blockingRuleS(deceased);
                    BlockingRules.blockingRuleT(deceased);
                }

                if (heir.isBlocked() == false) {
                    if (heir.isHusband()) {
                        double thehusbandportion = StandardRules.getHusbandportion(deceased);
                        husbandPortion += thehusbandportion;
                    } else if (heir.isWife()) {
                        double thewifeportion = StandardRules.getWifeportion(deceased, noOfWives);
                        husbandPortion += thewifeportion;
                    } else if (heir.isGrandSon()) {
                        double thegrandsonportion = StandardRules.getGrandsonportion(deceased);
                        allGrandsonPortion += thegrandsonportion;
                    } else if (heir.isGrandDaughter()) {
                        double thegranddaughterportion = StandardRules.getGrandDaughterportion(deceased);
                        allGranddaughterPortion += thegranddaughterportion;
                    } else if (heir.isFather()) {
                        double thefatherportion = StandardRules.getFatherportion(deceased);
                        fatherPortion += thefatherportion;
                    } else if (heir.isMother()) {
                        double themotherportion = StandardRules.getMotherportion(deceased);
                        motherPortion += themotherportion;
                    } else if (heir.isGrandFather()) {
                        double thegrandfatherportion = StandardRules.getGrandFatherportion(deceased);
                        grandfatherPortion += thegrandfatherportion;
                    } else if (heir.isPaternalGrandMother()) {
                        double thepaternalgrandmotherportion = StandardRules.getPaternalGrandMotherportion(deceased);
                        paternalGrandmotherPortion += thepaternalgrandmotherportion;
                    } else if (heir.isMaternalGrandMother()) {
                        double theMaternalGrandmotherPortion = StandardRules.getMaternalGrandMotherportion(deceased);
                        maternalGrandmotherPortion += theMaternalGrandmotherPortion;
                    } else if (heir.isFullBrother()) {
                        double theFullBrotherportion = StandardRules.getFullBrotherportion(deceased);
                        allFullBrotherPortion += theFullBrotherportion;
                    } else if (heir.isFullSister()) {
                        double theFullSisterPortion = StandardRules.getFullSisterportion(deceased);
                        allFullSisterPortion += theFullSisterPortion;
                    } else if (heir.isMaternalBrother()) {
                        double theMaternalBrotherPortion = StandardRules.getMaternalSiblingportion(deceased);
                        allMaternalBrotherPortion += theMaternalBrotherPortion;
                    } else if (heir.isMaternalSister()) {
                        double theMaternalSisterPortion = StandardRules.getMaternalSiblingportion(deceased);
                        allMaternalSisterPortion += theMaternalSisterPortion;
                    } else if (heir.isNephew()) {
                        double thenephewportion = StandardRules.getNephewportion(deceased);
                        allNephewPortion += thenephewportion;
                    } else if (heir.isPaternalNephew()) {
                        double thePaternalNephewportion = StandardRules.getPaternalNephewportion(deceased);
                        allPaternalNephewPortion += thePaternalNephewportion;
                    } else if (heir.isNephewSon()) {
                        double theNephewSonportion = StandardRules.getNephewSonportion(deceased);
                        allNephewSonPortion += theNephewSonportion;
                    } else if (heir.isPaternalNephewSon()) {
                        double thePaternaNephewSonportion = StandardRules.getPaternalNephewSonportion(deceased);
                        allPaternalNephewSonPortion += thePaternaNephewSonportion;
                    } else if (heir.isUncle()) {
                        double theUncleportion = StandardRules.getUncleportion(deceased);
                        allUnclePortion += theUncleportion;
                    } else if (heir.isPaternalUncle()) {
                        double thePaternalUncleportion = StandardRules.getPaternalUncleportion(deceased);
                        allPaternalUnclePortion += thePaternalUncleportion;
                    } else if (heir.isCousin()) {
                        double theCousinportion = StandardRules.getCousinportion(deceased);
                        allCousinPortion += theCousinportion;
                    } else if (heir.isCousinSon()) {
                        double theCousinSonportion = StandardRules.getCousinSonportion(deceased);
                        allCousinSonPortion += theCousinSonportion;
                    } else if (heir.isPaternalCousinSon()) {
                        double thePaternalCousinSonportion = StandardRules.getPaternalCousinSonportion(deceased);
                        allPaternalCousinSonPortion += thePaternalCousinSonportion;
                    } else if (heir.isCousinGrandson()) {
                        double theCousinGrandsonportion = StandardRules.getCousinGrandsonportion(deceased);
                        allCousinGrandsonPortion += theCousinGrandsonportion;
                    } else if (heir.isPaternalCousinGrandson()) {
                        double thePaternalCousinGrandsonportion = StandardRules.getPaternalCousinGrandsonportion(deceased);
                        allPaternalCousinGrandsonPortion += thePaternalCousinGrandsonportion;
                    }
                    unblockedheirs.add(heir);
                }

            }
            if (deceased.getGender().equals(Person.MALE)) {

                remainingportion = deceased.getLegacy() - (wifePortion + allGrandsonPortion + allGranddaughterPortion + fatherPortion
                        + motherPortion + grandfatherPortion + paternalGrandmotherPortion + maternalGrandmotherPortion
                        + allFullBrotherPortion + allFullSisterPortion + allMaternalBrotherPortion + allMaternalSisterPortion
                        + allNephewPortion + allPaternalNephewPortion + allNephewSonPortion + allPaternalNephewSonPortion
                        + allUnclePortion + allPaternalUnclePortion + allCousinPortion + allPaternalCousinPortion
                        + allCousinSonPortion + allPaternalCousinSonPortion + allCousinGrandsonPortion
                        + allPaternalCousinGrandsonPortion);

                paternalSisterPortion = remainingportion / (noOfPaternalSisters + (noOfPaternalBrothers * 2));
                paternaBrotherportion = 2 * paternalSisterPortion;

            } else if (deceased.getGender().equals(Person.FEMALE)) {

                remainingportion = deceased.getLegacy() - (husbandPortion + allGrandsonPortion + allGranddaughterPortion + fatherPortion
                        + motherPortion + grandfatherPortion + paternalGrandmotherPortion + maternalGrandmotherPortion
                        + allFullBrotherPortion + allFullSisterPortion + allMaternalBrotherPortion + allMaternalSisterPortion
                        + allNephewPortion + allPaternalNephewPortion + allNephewSonPortion + allPaternalNephewSonPortion
                        + allUnclePortion + allPaternalUnclePortion + allCousinPortion + allPaternalCousinPortion
                        + allCousinSonPortion + allPaternalCousinSonPortion + allCousinGrandsonPortion
                        + allPaternalCousinGrandsonPortion);

                paternalSisterPortion = remainingportion / (noOfPaternalSisters + (noOfPaternalBrothers * 2));
                paternaBrotherportion = 2 * paternalSisterPortion;
            }
        }
        return paternaBrotherportion;




        //end
    }

    private static double getFullBrotherportion(Deceased deceased) {
        //begin
        int noOfWives = 0;
        int noOfFullBrothers = 0;
        int noOfFullSisters = 0;

        double fullSisterPortion = 0.0;
        double fullBrotherportion = 0.0;
        double remainingportion = 0.0;

        List<Heir> theHeirs = deceased.getHeirs();

        for (Heir heir: theHeirs) {
            if (heir.isFullBrother())
                noOfFullBrothers++;
            else if (heir.isWife()) {
                noOfWives++;
            } else if (heir.isFullSister()) {
                noOfFullSisters++;
            }
        }

        if (!deceased.hasNoFullBrother()) {
            List<Heir> unblockedheirs = new ArrayList<>();

            double husbandPortion = 0.0;
            double wifePortion = 0.0;
            double allGrandsonPortion = 0.0;
            double allGranddaughterPortion = 0.0;
            double fatherPortion = 0.0;
            double motherPortion = 0.0;
            double grandfatherPortion = 0.0;
            double paternalGrandmotherPortion = 0.0;
            double maternalGrandmotherPortion = 0.0;
            double allMaternalBrotherPortion = 0.0;
            double allMaternalSisterPortion = 0.0;
            double allNephewPortion = 0.0;
            double allPaternalNephewPortion = 0.0;
            double allNephewSonPortion = 0.0;
            double allPaternalNephewSonPortion = 0.0;
            double allUnclePortion = 0.0;
            double allPaternalUnclePortion = 0.0;
            double allCousinPortion = 0.0;
            double allPaternalCousinPortion = 0.0;
            double allCousinSonPortion = 0.0;
            double allPaternalCousinSonPortion = 0.0;
            double allCousinGrandsonPortion = 0.0;
            double allPaternalCousinGrandsonPortion = 0.0;

            for (Heir heir : theHeirs) {

                if (heir.isBlockable()) {

                    BlockingRules.blockingRuleA(deceased);
                    BlockingRules.blockingRuleB(deceased);
                    BlockingRules.blockingRuleC(deceased);
                    BlockingRules.blockingRuleD(deceased);
                    BlockingRules.blockingRuleE(deceased);
                    BlockingRules.blockingRuleF(deceased);
                    BlockingRules.blockingRuleG(deceased);
                    BlockingRules.blockingRuleH(deceased);
                    BlockingRules.blockingRuleI(deceased);
                    BlockingRules.blockingRuleK(deceased);
                    BlockingRules.blockingRuleL(deceased);
                    BlockingRules.blockingRuleM(deceased);
                    BlockingRules.blockingRuleN(deceased);
                    BlockingRules.blockingRuleO(deceased);
                    BlockingRules.blockingRuleP(deceased);
                    BlockingRules.blockingRuleQ(deceased);
                    BlockingRules.blockingRuleR(deceased);
                    BlockingRules.blockingRuleS(deceased);
                    BlockingRules.blockingRuleT(deceased);
                }

                if (heir.isBlocked() == false) {
                    if (heir.isHusband()) {
                        double thehusbandportion = StandardRules.getHusbandportion(deceased);
                        husbandPortion += thehusbandportion;
                    } else if (heir.isWife()) {
                        double thewifeportion = StandardRules.getWifeportion(deceased, noOfWives);
                        husbandPortion += thewifeportion;
                    } else if (heir.isGrandSon()) {
                        double thegrandsonportion = StandardRules.getGrandsonportion(deceased);
                        allGrandsonPortion += thegrandsonportion;
                    } else if (heir.isGrandDaughter()) {
                        double thegranddaughterportion = StandardRules.getGrandDaughterportion(deceased);
                        allGranddaughterPortion += thegranddaughterportion;
                    } else if (heir.isFather()) {
                        double thefatherportion = StandardRules.getFatherportion(deceased);
                        fatherPortion += thefatherportion;
                    } else if (heir.isMother()) {
                        double themotherportion = StandardRules.getMotherportion(deceased);
                        motherPortion += themotherportion;
                    } else if (heir.isGrandFather()) {
                        double thegrandfatherportion = StandardRules.getGrandFatherportion(deceased);
                        grandfatherPortion += thegrandfatherportion;
                    } else if (heir.isPaternalGrandMother()) {
                        double thepaternalgrandmotherportion = StandardRules.getPaternalGrandMotherportion(deceased);
                        paternalGrandmotherPortion += thepaternalgrandmotherportion;
                    } else if (heir.isMaternalGrandMother()) {
                        double theMaternalGrandmotherPortion = StandardRules.getMaternalGrandMotherportion(deceased);
                        maternalGrandmotherPortion += theMaternalGrandmotherPortion;
                    } else if (heir.isMaternalBrother()) {
                        double theMaternalBrotherPortion = StandardRules.getMaternalSiblingportion(deceased);
                        allMaternalBrotherPortion += theMaternalBrotherPortion;
                    } else if (heir.isMaternalSister()) {
                        double theMaternalSisterPortion = StandardRules.getMaternalSiblingportion(deceased);
                        allMaternalSisterPortion += theMaternalSisterPortion;
                    } else if (heir.isNephew()) {
                        double thenephewportion = StandardRules.getNephewportion(deceased);
                        allNephewPortion += thenephewportion;
                    } else if (heir.isPaternalNephew()) {
                        double thePaternalNephewportion = StandardRules.getPaternalNephewportion(deceased);
                        allPaternalNephewPortion += thePaternalNephewportion;
                    } else if (heir.isNephewSon()) {
                        double theNephewSonportion = StandardRules.getNephewSonportion(deceased);
                        allNephewSonPortion += theNephewSonportion;
                    } else if (heir.isPaternalNephewSon()) {
                        double thePaternaNephewSonportion = StandardRules.getPaternalNephewSonportion(deceased);
                        allPaternalNephewSonPortion += thePaternaNephewSonportion;
                    } else if (heir.isUncle()) {
                        double theUncleportion = StandardRules.getUncleportion(deceased);
                        allUnclePortion += theUncleportion;
                    } else if (heir.isPaternalUncle()) {
                        double thePaternalUncleportion = StandardRules.getPaternalUncleportion(deceased);
                        allPaternalUnclePortion += thePaternalUncleportion;
                    } else if (heir.isCousin()) {
                        double theCousinportion = StandardRules.getCousinportion(deceased);
                        allCousinPortion += theCousinportion;
                    } else if (heir.isCousinSon()) {
                        double theCousinSonportion = StandardRules.getCousinSonportion(deceased);
                        allCousinSonPortion += theCousinSonportion;
                    } else if (heir.isPaternalCousinSon()) {
                        double thePaternalCousinSonportion = StandardRules.getPaternalCousinSonportion(deceased);
                        allPaternalCousinSonPortion += thePaternalCousinSonportion;
                    } else if (heir.isCousinGrandson()) {
                        double theCousinGrandsonportion = StandardRules.getCousinGrandsonportion(deceased);
                        allCousinGrandsonPortion += theCousinGrandsonportion;
                    } else if (heir.isPaternalCousinGrandson()) {
                        double thePaternalCousinGrandsonportion = StandardRules.getPaternalCousinGrandsonportion(deceased);
                        allPaternalCousinGrandsonPortion += thePaternalCousinGrandsonportion;
                    }
                    unblockedheirs.add(heir);
                }

            }
            if (deceased.getGender().equals(Person.MALE)) {

                remainingportion = deceased.getLegacy() - (wifePortion + allGrandsonPortion + allGranddaughterPortion + fatherPortion
                        + motherPortion + grandfatherPortion + paternalGrandmotherPortion + maternalGrandmotherPortion
                        + allMaternalBrotherPortion + allMaternalSisterPortion
                        + allNephewPortion + allPaternalNephewPortion + allNephewSonPortion + allPaternalNephewSonPortion
                        + allUnclePortion + allPaternalUnclePortion + allCousinPortion + allPaternalCousinPortion
                        + allCousinSonPortion + allPaternalCousinSonPortion + allCousinGrandsonPortion
                        + allPaternalCousinGrandsonPortion);

                fullSisterPortion = remainingportion / (noOfFullSisters + (noOfFullBrothers * 2));
                fullBrotherportion = 2 * fullSisterPortion;

            } else if (deceased.getGender().equals(Person.FEMALE)) {

                remainingportion = deceased.getLegacy() - (husbandPortion + allGrandsonPortion + allGranddaughterPortion + fatherPortion
                        + motherPortion + grandfatherPortion + paternalGrandmotherPortion + maternalGrandmotherPortion
                        + allMaternalBrotherPortion + allMaternalSisterPortion
                        + allNephewPortion + allPaternalNephewPortion + allNephewSonPortion + allPaternalNephewSonPortion
                        + allUnclePortion + allPaternalUnclePortion + allCousinPortion + allPaternalCousinPortion
                        + allCousinSonPortion + allPaternalCousinSonPortion + allCousinGrandsonPortion
                        + allPaternalCousinGrandsonPortion);

                fullSisterPortion = remainingportion / (noOfFullSisters + (noOfFullBrothers * 2));
                fullBrotherportion = 2 * fullSisterPortion;
            }
        }
        return fullBrotherportion;



        //end
    }

    private static double getGrandsonportion(Deceased deceased) {
        //begin
        int noOfGrandDaughters = 0;
        int noOfWives = 0;
        int noOfGrandSons = 0;

        double granddaughterportion = 0.0;
        double remainingportion = 0.0;
        double grandsonportion = 0.0;

        List<Heir> theheirs = deceased.getHeirs();

        for (Heir heir: theheirs){

            if (heir.isGrandDaughter()){
                noOfGrandDaughters++;
            } else if (heir.isWife()) {
                noOfWives++;
            } else if (heir.isGrandSon()) {
                noOfGrandSons++;
            }
        }

        if (!deceased.hasNoGrandSonFromSon()){

            List<Heir> unblockedheirs = new ArrayList<>();

            double husbandPortion = 0.0;
            double wifePortion = 0.0;
            double fatherPortion = 0.0;
            double motherPortion = 0.0;
            double grandfatherPortion = 0.0;
            double paternalGrandmotherPortion = 0.0;
            double maternalGrandmotherPortion = 0.0;
            double allFullBrotherPortion = 0.0;
            double allFullSisterPortion = 0.0;
            double allPaternalBrotherPortion = 0.0;
            double allPaternalSisterPortion = 0.0;
            double allMaternalBrotherPortion = 0.0;
            double allMaternalSisterPortion = 0.0;
            double allNephewPortion = 0.0;
            double allPaternalNephewPortion = 0.0;
            double allNephewSonPortion = 0.0;
            double allPaternalNephewSonPortion = 0.0;
            double allUnclePortion = 0.0;
            double allPaternalUnclePortion = 0.0;
            double allCousinPortion = 0.0;
            double allPaternalCousinPortion = 0.0;
            double allCousinSonPortion = 0.0;
            double allPaternalCousinSonPortion = 0.0;
            double allCousinGrandsonPortion = 0.0;
            double allPaternalCousinGrandsonPortion = 0.0;

            for (Heir heir: theheirs) {

                if (heir.isBlockable()){

                    BlockingRules.blockingRuleA(deceased);
                    BlockingRules.blockingRuleB(deceased);
                    BlockingRules.blockingRuleC(deceased);
                    BlockingRules.blockingRuleD(deceased);
                    BlockingRules.blockingRuleE(deceased);
                    BlockingRules.blockingRuleF(deceased);
                    BlockingRules.blockingRuleG(deceased);
                    BlockingRules.blockingRuleH(deceased);
                    BlockingRules.blockingRuleI(deceased);
                    BlockingRules.blockingRuleK(deceased);
                    BlockingRules.blockingRuleL(deceased);
                    BlockingRules.blockingRuleM(deceased);
                    BlockingRules.blockingRuleN(deceased);
                    BlockingRules.blockingRuleO(deceased);
                    BlockingRules.blockingRuleP(deceased);
                    BlockingRules.blockingRuleQ(deceased);
                    BlockingRules.blockingRuleR(deceased);
                    BlockingRules.blockingRuleS(deceased);
                    BlockingRules.blockingRuleT(deceased);
                }

                if (heir.isBlocked() == false){

                    if (heir.isHusband()){
                        double thehusbandportion = StandardRules.getHusbandportion(deceased);
                        husbandPortion += thehusbandportion;
                    }

                    else if (heir.isWife()){
                        double thewifeportion = StandardRules.getWifeportion(deceased , noOfWives);
                        husbandPortion += thewifeportion;
                    }
                    else if (heir.isFather()){
                        double thefatherportion = StandardRules.getFatherportion(deceased);
                        fatherPortion += thefatherportion;
                    }

                    else if (heir.isMother()){
                        double themotherportion = StandardRules.getMotherportion(deceased);
                        motherPortion += themotherportion;
                    }

                    else if (heir.isGrandFather()){
                        double thegrandfatherportion = StandardRules.getGrandFatherportion(deceased);
                        grandfatherPortion += thegrandfatherportion;
                    }

                    else if (heir.isPaternalGrandMother()){
                        double thepaternalgrandmotherportion = StandardRules.getPaternalGrandMotherportion(deceased);
                        paternalGrandmotherPortion += thepaternalgrandmotherportion;
                    }

                    else if(heir.isMaternalGrandMother())
                    {
                        double theMaternalGrandmotherPortion = StandardRules.getMaternalGrandMotherportion(deceased);
                        maternalGrandmotherPortion += theMaternalGrandmotherPortion;
                    }
                    else if(heir.isFullBrother())
                    {
                        double theFullBrotherportion = StandardRules.getFullBrotherportion(deceased);
                        allFullBrotherPortion += theFullBrotherportion;
                    }
                    else if(heir.isFullSister())
                    {
                        double theFullSisterPortion = StandardRules.getFullSisterportion(deceased);
                        allFullSisterPortion += theFullSisterPortion;
                    }

                    else if(heir.isMaternalBrother())
                    {
                        double theMaternalBrotherPortion = StandardRules.getMaternalSiblingportion(deceased);
                        allMaternalBrotherPortion += theMaternalBrotherPortion;
                    }
                    else if(heir.isMaternalSister())
                    {
                        double theMaternalSisterPortion = StandardRules.getMaternalSiblingportion(deceased);
                        allMaternalSisterPortion += theMaternalSisterPortion;
                    }
                    else if(heir.isNephew())
                    {
                        double thenephewportion = StandardRules.getNephewportion(deceased);
                        allNephewPortion += thenephewportion;
                    }
                    else if(heir.isPaternalNephew())
                    {
                        double thePaternalNephewportion = StandardRules.getPaternalNephewportion(deceased);
                        allPaternalNephewPortion += thePaternalNephewportion;
                    }
                    else if(heir.isNephewSon())
                    {
                        double theNephewSonportion = StandardRules.getNephewSonportion(deceased);
                        allNephewSonPortion += theNephewSonportion;
                    }
                    else if(heir.isPaternalNephewSon())
                    {
                        double thePaternaNephewSonportion = StandardRules.getPaternalNephewSonportion(deceased);
                        allPaternalNephewSonPortion += thePaternaNephewSonportion;
                    }
                    else if(heir.isUncle())
                    {
                        double theUncleportion = StandardRules.getUncleportion(deceased);
                        allUnclePortion += theUncleportion;
                    }
                    else if(heir.isPaternalUncle())
                    {
                        double thePaternalUncleportion = StandardRules.getPaternalUncleportion(deceased);
                        allPaternalUnclePortion += thePaternalUncleportion;
                    }
                    else if(heir.isCousin())
                    {
                        double theCousinportion = StandardRules.getCousinportion(deceased);
                        allCousinPortion += theCousinportion;
                    }
                    else if(heir.isCousinSon())
                    {
                        double theCousinSonportion = StandardRules.getCousinSonportion(deceased);
                        allCousinSonPortion += theCousinSonportion;
                    }
                    else if(heir.isPaternalCousinSon())
                    {
                        double thePaternalCousinSonportion = StandardRules.getPaternalCousinSonportion(deceased);
                        allPaternalCousinSonPortion += thePaternalCousinSonportion;
                    }
                    else if(heir.isCousinGrandson())
                    {
                        double theCousinGrandsonportion = StandardRules.getCousinGrandsonportion(deceased);
                        allCousinGrandsonPortion += theCousinGrandsonportion;
                    }
                    else if(heir.isPaternalCousinGrandson())
                    {
                        double thePaternalCousinGrandsonportion = StandardRules.getPaternalCousinGrandsonportion(deceased);
                        allPaternalCousinGrandsonPortion += thePaternalCousinGrandsonportion;
                    }
                    unblockedheirs.add(heir);
                }
            }

            if(deceased.getGender().equals(Person.MALE)) {

                //we devide the legacy on the prescribed heirs first
                remainingportion = deceased.getLegacy() - (wifePortion + fatherPortion
                        + motherPortion + grandfatherPortion + paternalGrandmotherPortion + maternalGrandmotherPortion
                        + allFullBrotherPortion + allFullSisterPortion + allPaternalBrotherPortion
                        + allPaternalSisterPortion + allMaternalBrotherPortion + allMaternalSisterPortion
                        + allNephewPortion + allPaternalNephewPortion + allNephewSonPortion + allPaternalNephewSonPortion
                        + allUnclePortion + allPaternalUnclePortion + allCousinPortion + allPaternalCousinPortion
                        + allCousinSonPortion + allPaternalCousinSonPortion + allCousinGrandsonPortion
                        + allPaternalCousinGrandsonPortion);

                //the son will inherite as ASABAH (he will inherit double what the daughter's share)
                granddaughterportion = remainingportion / (noOfGrandDaughters + (noOfGrandSons * 2));
                grandsonportion = 2 * granddaughterportion;
            }
            else if(deceased.getGender().equals(Person.FEMALE)) {

                //we devide the legacy on the prescribed heirs first
                remainingportion = deceased.getLegacy() - (husbandPortion + fatherPortion
                        + motherPortion + grandfatherPortion + paternalGrandmotherPortion + maternalGrandmotherPortion
                        + allFullBrotherPortion + allFullSisterPortion + allPaternalBrotherPortion
                        + allPaternalSisterPortion + allMaternalBrotherPortion + allMaternalSisterPortion
                        + allNephewPortion + allPaternalNephewPortion + allNephewSonPortion + allPaternalNephewSonPortion
                        + allUnclePortion + allPaternalUnclePortion + allCousinPortion + allPaternalCousinPortion
                        + allCousinSonPortion + allPaternalCousinSonPortion + allCousinGrandsonPortion
                        + allPaternalCousinGrandsonPortion);

                //the son will inherite as ASABAH (he inherites from what remains)
                granddaughterportion = remainingportion / (noOfGrandDaughters + (noOfGrandSons * 2));
                grandsonportion = 2 * granddaughterportion;
            }

        }


        return grandsonportion;



        //end
    }

    public static double getFatherportion(Deceased deceased) {
        double fatherPortion = 0.0;
        if(deceased.hasoffspring())
            fatherPortion = deceased.getLegacy() / 6;
        return fatherPortion;
    }

    public static double getMotherportion(Deceased deceased) {
        double motherPortion = 0.0;
        if(!deceased.hasoffspring() && deceased.hasNotMultipleSiblings())
            motherPortion = deceased.getLegacy() / 3;
        else if(deceased.hasoffspring() || deceased.hasMultipleSiblings())
            motherPortion = deceased.getLegacy() / 6;
        return motherPortion;
    }

    public static double getGrandFatherportion(Deceased deceased)
    {
        double paternalGrandFatherPortion = 0.0;
        if(deceased.hasNoFather() && deceased.hasoffspring())
            paternalGrandFatherPortion = deceased.getLegacy() / 6;
        return paternalGrandFatherPortion;
    }



    public static double getPaternalGrandMotherportion(Deceased deceased) {
        double paternalGrandMotherPortion = 0.0;
        if(deceased.hasNotMother() && deceased.hasNoFather() && deceased.hasNotMaternalGrandMother())
            paternalGrandMotherPortion = deceased.getLegacy() / 6;
        else if(deceased.hasNotMother() && deceased.hasNoFather() && !deceased.hasNotMaternalGrandMother())
            paternalGrandMotherPortion = deceased.getLegacy() / 12;
        return paternalGrandMotherPortion;
    }

    public static double getMaternalGrandMotherportion(Deceased deceased)
    {
        double maternalGrandFatherPortion = 0.0;
        if(deceased.hasNotMother())
            maternalGrandFatherPortion = deceased.getLegacy() / 6;
        else if(deceased.hasNotMother() && deceased.hasNoFather() && !deceased.hasNotPaternalGrandMother())
            maternalGrandFatherPortion = deceased.getLegacy() / 12;
        return maternalGrandFatherPortion;
    }

    public static double getFullSisterportion(Deceased deceased)
    {
        int noOfFullSisters = 0;
        double fullSisterPortion = 0.0;
        List<Heir> theHeirs = deceased.getHeirs();
        for(Heir theHeir : theHeirs)
        {
            if(theHeir.isFullSister())
                ++noOfFullSisters;
        }
        if(deceased.hasOnlyOneFullSister() && !deceased.hasoffspring() && deceased.hasNoMalePaternalAncestor() && deceased.hasNoFullBrother())
            fullSisterPortion = deceased.getLegacy() / 2;
        else if(deceased.hasManyFullSisters() && !deceased.hasoffspring() && deceased.hasNoMalePaternalAncestor() && deceased.hasNoFullBrother())
            fullSisterPortion = (deceased.getLegacy() * 2) / (3 * noOfFullSisters);
        else if (!deceased.hasoffspring() && deceased.hasNoMalePaternalAncestor() && !deceased.hasNoFullBrother()) {
            int noOfFullBrothers = 0;
            int noOfWives = 0;

            double remainingportion = 0.0;

            for (Heir heir: theHeirs) {
                if (heir.isWife())
                    noOfWives++;
                else if (heir.isFullBrother()) {
                    noOfFullBrothers++;
                }
            }

            List<Heir> unblockedheirs = new ArrayList<>();

            double husbandPortion = 0.0;
            double wifePortion = 0.0;
            double allGrandsonPortion = 0.0;
            double allGranddaughterPortion = 0.0;
            double fatherPortion = 0.0;
            double motherPortion = 0.0;
            double grandfatherPortion = 0.0;
            double paternalGrandmotherPortion = 0.0;
            double maternalGrandmotherPortion = 0.0;
            double allMaternalBrotherPortion = 0.0;
            double allMaternalSisterPortion = 0.0;
            double allNephewPortion = 0.0;
            double allPaternalNephewPortion = 0.0;
            double allNephewSonPortion = 0.0;
            double allPaternalNephewSonPortion = 0.0;
            double allUnclePortion = 0.0;
            double allPaternalUnclePortion = 0.0;
            double allCousinPortion = 0.0;
            double allPaternalCousinPortion = 0.0;
            double allCousinSonPortion = 0.0;
            double allPaternalCousinSonPortion = 0.0;
            double allCousinGrandsonPortion = 0.0;
            double allPaternalCousinGrandsonPortion = 0.0;

            for (Heir heir: theHeirs) {

                if (heir.isBlockable()){

                    BlockingRules.blockingRuleA(deceased);
                    BlockingRules.blockingRuleB(deceased);
                    BlockingRules.blockingRuleC(deceased);
                    BlockingRules.blockingRuleD(deceased);
                    BlockingRules.blockingRuleE(deceased);
                    BlockingRules.blockingRuleF(deceased);
                    BlockingRules.blockingRuleG(deceased);
                    BlockingRules.blockingRuleH(deceased);
                    BlockingRules.blockingRuleI(deceased);
                    BlockingRules.blockingRuleK(deceased);
                    BlockingRules.blockingRuleL(deceased);
                    BlockingRules.blockingRuleM(deceased);
                    BlockingRules.blockingRuleN(deceased);
                    BlockingRules.blockingRuleO(deceased);
                    BlockingRules.blockingRuleP(deceased);
                    BlockingRules.blockingRuleQ(deceased);
                    BlockingRules.blockingRuleR(deceased);
                    BlockingRules.blockingRuleS(deceased);
                    BlockingRules.blockingRuleT(deceased);
                }

                if (heir.isBlocked() == false){
                    if (heir.isHusband()){
                        double thehusbandportion = StandardRules.getHusbandportion(deceased);
                        husbandPortion += thehusbandportion;
                    }

                    else if (heir.isWife()){
                        double thewifeportion = StandardRules.getWifeportion(deceased , noOfWives);
                        husbandPortion += thewifeportion;
                    }

                    else if (heir.isGrandSon()){
                        double thegrandsonportion = StandardRules.getGrandsonportion(deceased);
                        allGrandsonPortion += thegrandsonportion;
                    }

                    else if (heir.isGrandDaughter()){
                        double thegranddaughterportion = StandardRules.getGrandDaughterportion(deceased);
                        allGranddaughterPortion += thegranddaughterportion;
                    }

                    else if (heir.isFather()){
                        double thefatherportion = StandardRules.getFatherportion(deceased);
                        fatherPortion += thefatherportion;
                    }

                    else if (heir.isMother()){
                        double themotherportion = StandardRules.getMotherportion(deceased);
                        motherPortion += themotherportion;
                    }

                    else if (heir.isGrandFather()){
                        double thegrandfatherportion = StandardRules.getGrandFatherportion(deceased);
                        grandfatherPortion += thegrandfatherportion;
                    }

                    else if (heir.isPaternalGrandMother()){
                        double thepaternalgrandmotherportion = StandardRules.getPaternalGrandMotherportion(deceased);
                        paternalGrandmotherPortion += thepaternalgrandmotherportion;
                    }

                    else if(heir.isMaternalGrandMother())
                    {
                        double theMaternalGrandmotherPortion = StandardRules.getMaternalGrandMotherportion(deceased);
                        maternalGrandmotherPortion += theMaternalGrandmotherPortion;
                    }
                    else if(heir.isMaternalBrother())
                    {
                        double theMaternalBrotherPortion = StandardRules.getMaternalSiblingportion(deceased);
                        allMaternalBrotherPortion += theMaternalBrotherPortion;
                    }
                    else if(heir.isMaternalSister())
                    {
                        double theMaternalSisterPortion = StandardRules.getMaternalSiblingportion(deceased);
                        allMaternalSisterPortion += theMaternalSisterPortion;
                    }
                    else if(heir.isNephew())
                    {
                        double thenephewportion = StandardRules.getNephewportion(deceased);
                        allNephewPortion += thenephewportion;
                    }
                    else if(heir.isPaternalNephew())
                    {
                        double thePaternalNephewportion = StandardRules.getPaternalNephewportion(deceased);
                        allPaternalNephewPortion += thePaternalNephewportion;
                    }
                    else if(heir.isNephewSon())
                    {
                        double theNephewSonportion = StandardRules.getNephewSonportion(deceased);
                        allNephewSonPortion += theNephewSonportion;
                    }
                    else if(heir.isPaternalNephewSon())
                    {
                        double thePaternaNephewSonportion = StandardRules.getPaternalNephewSonportion(deceased);
                        allPaternalNephewSonPortion += thePaternaNephewSonportion;
                    }
                    else if(heir.isUncle())
                    {
                        double theUncleportion = StandardRules.getUncleportion(deceased);
                        allUnclePortion += theUncleportion;
                    }
                    else if(heir.isPaternalUncle())
                    {
                        double thePaternalUncleportion = StandardRules.getPaternalUncleportion(deceased);
                        allPaternalUnclePortion += thePaternalUncleportion;
                    }
                    else if(heir.isCousin())
                    {
                        double theCousinportion = StandardRules.getCousinportion(deceased);
                        allCousinPortion += theCousinportion;
                    }
                    else if(heir.isCousinSon())
                    {
                        double theCousinSonportion = StandardRules.getCousinSonportion(deceased);
                        allCousinSonPortion += theCousinSonportion;
                    }
                    else if(heir.isPaternalCousinSon())
                    {
                        double thePaternalCousinSonportion = StandardRules.getPaternalCousinSonportion(deceased);
                        allPaternalCousinSonPortion += thePaternalCousinSonportion;
                    }
                    else if(heir.isCousinGrandson())
                    {
                        double theCousinGrandsonportion = StandardRules.getCousinGrandsonportion(deceased);
                        allCousinGrandsonPortion += theCousinGrandsonportion;
                    }
                    else if(heir.isPaternalCousinGrandson())
                    {
                        double thePaternalCousinGrandsonportion = StandardRules.getPaternalCousinGrandsonportion(deceased);
                        allPaternalCousinGrandsonPortion += thePaternalCousinGrandsonportion;
                    }
                    unblockedheirs.add(heir);
                }
            }

            if(deceased.getGender().equals(Person.MALE)) {

                remainingportion = deceased.getLegacy() - (wifePortion + allGrandsonPortion + allGranddaughterPortion + fatherPortion
                        + motherPortion + grandfatherPortion + paternalGrandmotherPortion + maternalGrandmotherPortion
                        + allMaternalBrotherPortion + allMaternalSisterPortion
                        + allNephewPortion + allPaternalNephewPortion + allNephewSonPortion + allPaternalNephewSonPortion
                        + allUnclePortion + allPaternalUnclePortion + allCousinPortion + allPaternalCousinPortion
                        + allCousinSonPortion + allPaternalCousinSonPortion + allCousinGrandsonPortion
                        + allPaternalCousinGrandsonPortion);

                fullSisterPortion = remainingportion / (noOfFullSisters + (noOfFullBrothers * 2));
            }
            else if(deceased.getGender().equals(Person.FEMALE)) {

                remainingportion = deceased.getLegacy() - (husbandPortion + allGrandsonPortion + allGranddaughterPortion + fatherPortion
                        + motherPortion + grandfatherPortion + paternalGrandmotherPortion + maternalGrandmotherPortion
                        + allMaternalBrotherPortion + allMaternalSisterPortion
                        + allNephewPortion + allPaternalNephewPortion + allNephewSonPortion + allPaternalNephewSonPortion
                        + allUnclePortion + allPaternalUnclePortion + allCousinPortion + allPaternalCousinPortion
                        + allCousinSonPortion + allPaternalCousinSonPortion + allCousinGrandsonPortion
                        + allPaternalCousinGrandsonPortion);

                fullSisterPortion = remainingportion / (noOfFullSisters + (noOfFullBrothers * 2));
            }
        }


        return fullSisterPortion;
    }




}


