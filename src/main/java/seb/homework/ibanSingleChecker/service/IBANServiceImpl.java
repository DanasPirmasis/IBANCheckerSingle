package seb.homework.ibanSingleChecker.service;

import org.springframework.stereotype.Service;

import java.math.BigInteger;

@Service
class IBANServiceImpl implements IBANService{
    @Override
    public boolean checkIfBelongsToSEB(String ibanNumber) {
        if(ibanNumber.length() > 0) {
            if(ibanNumber.substring(4,9).equals("70440")) {
                return true;
            }
        }
        return false;
    }
    @Override
    public boolean checkIfValid(String ibanNumber) {

        String modifiedIBAN = removeSpacesAndMoveIBANCharacters(ibanNumber);

        if (ibanNumber.length() != 20) {
            return false;
        }

        modifiedIBAN = lettersToIntegers(modifiedIBAN);

        if (modifiedIBAN == null) {
            return false;
        }

        BigInteger ibanNumberToBigInt = new BigInteger(modifiedIBAN);
        return ibanNumberToBigInt.mod(BigInteger.valueOf(97)).intValue() == 1;
    }

    private String removeSpacesAndMoveIBANCharacters(String ibanNumber) {

        String modifiedIBAN = ibanNumber.replaceAll("\\s", "");
        if (modifiedIBAN.length() > 4) {
            modifiedIBAN = modifiedIBAN.substring(4) + modifiedIBAN.substring(0, 4);
        }

        return modifiedIBAN;
    }

    private String lettersToIntegers(String ibanNumber) {
        StringBuilder ibanNumberToIntegers = new StringBuilder();

        for (int i = 0; i < ibanNumber.length(); i++) {
            int numericValue = Character.getNumericValue(ibanNumber.charAt(i));
            if (!checkForNegatives(numericValue)) return null;
            ibanNumberToIntegers.append(numericValue);
        }

        return ibanNumberToIntegers.toString();
    }

    private boolean checkForNegatives(int number) {
        return number >= 0;
    }
}
