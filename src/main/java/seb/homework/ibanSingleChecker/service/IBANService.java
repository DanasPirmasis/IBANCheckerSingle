package seb.homework.ibanSingleChecker.service;

public interface IBANService {
    boolean checkIfBelongsToSEB(String ibanNumber);
    boolean checkIfValid(String ibanNumber);
}
