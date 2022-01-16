package tests;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import domain.Validation;

public class PostalCodeTest {
   /**
   * @subcontract null postalCode {
   *   @requires postalCode == null;
   *   @signals (NullPointerException) postalCode == null;
   * }
   */

   @Test (expected=NullPointerException.class)
   public void checksPostalCodeWhenNull(){
      // Arrage
      String postalCode = null;
      // Act
      boolean result = Validation.checkPostalCode(postalCode);
   }

   /**
   *@subcontract valid postalCode 
   *   @requires four digits between 1000 and 9999 one space and two capital letters 
   *   @ensures \result = true
   *            
   */

   @Test
   public void PostalCodeIsValid(){
      // Arrage
      String postalCode = "4824 RT";
      // Act
      boolean result = Validation.checkPostalCode(postalCode);
      // Assert
      assertEquals(result, true);
   }

   /**
   *@subcontract valid postalCode 
   *   @requires four digits between 1000 and 9999 one space and two capital letters and one space
   *   @ensures \result = true
   *            
   */

   @Test
   public void PostalCodeValidSpaceAtTheEnd(){
      // Arrage
      String postalCode = "4824 RT ";
      // Act
      boolean result = Validation.checkPostalCode(postalCode);
      // Assert
      assertEquals(result, true);
   }

   /**
   * @subcontract invalid postalCode with three digits {
   *   @requires three digits space 2 capital letters;
   *   @signals (IllegalArgumentException);
   * }
   */

   @Test (expected=IllegalArgumentException.class)
   public void invalidPostalCode(){
      // Arrage
      String postalCode = "999 ZZ";
      // Act
      boolean result = Validation.checkPostalCode(postalCode);
   }

   /**
   * @subcontract invalid postalCode with five digits {
   *   @requires five digits one space two capital letters;
   *   @signals (IllegalArgumentException);
   * }
   */

   @Test (expected=IllegalArgumentException.class)
   public void invalidFiveDigitsPostalCode(){
      // Arrage
      String postalCode = "56721 TY";
      // Act
      boolean result = Validation.checkPostalCode(postalCode);
   }

   /**
   * @subcontract invalid postalCode without space {
   *   @requires four digits followed by two capital letters;
   *   @signals (IllegalArgumentException);
   * }
   */

   @Test (expected=IllegalArgumentException.class)
   public void invalidWithoutSpacePostalCode(){
      // Arrage
      String postalCode = "5129FN";
      // Act
      boolean result = Validation.checkPostalCode(postalCode);
   }

   /**
   * @subcontract invalid postalCode three Letters {
   *   @requires four digits space three capital letters;
   *   @signals (IllegalArgumentException);
   * }
   */

   @Test (expected=IllegalArgumentException.class)
   public void invalidThreeLettersPostalCode(){
      // Arrage
      String postalCode = "2459 FND";
      // Act
      boolean result = Validation.checkPostalCode(postalCode);
   }

   /**
   * @subcontract invalid postalCode two not capital Letters {
   *   @requires four digits space two small letters;
   *   @signals (IllegalArgumentException);
   * }
   */

   @Test (expected=IllegalArgumentException.class)
   public void invalidsmallLettersPostalCode(){
      // Arrage
      String postalCode = "6317 tr";
      // Act
      boolean result = Validation.checkPostalCode(postalCode);
   }

   /**
   * @subcontract invalid postalCode number is below 1000 {
   *   @requires first digit is a zero the next three between the 1-9 one space and 2 capital letters;
   *   @signals (IllegalArgumentException);
   * }
   */

   @Test (expected=IllegalArgumentException.class)
   public void invalidBelowThousandPostalCode(){
      // Arrage
      String postalCode = "0584 HQ";
      // Act
      boolean result = Validation.checkPostalCode(postalCode);
   }

   /**
   * @subcontract invalid postalCode two spaces {
   *   @requires four digits two spaces and two capital letters;
   *   @signals (IllegalArgumentException);
   * }
   */

   @Test (expected=IllegalArgumentException.class)
   public void invalidTwoSpacesPostalCode(){
      // Arrage
      String postalCode = "7451  TG";
      // Act
      boolean result = Validation.checkPostalCode(postalCode);
   }

   /**
   * @subcontract invalid postalCode four letter {
   *   @requires four capital letters one space and two digits ;
   *   @signals (IllegalArgumentException);
   * }
   */

   @Test (expected=IllegalArgumentException.class)
   public void invalidFourLettersPostalCode(){
      // Arrage
      String postalCode = "KFAP 43";
      // Act
      boolean result = Validation.checkPostalCode(postalCode);
   }
   
   /**
   * @subcontract invalid postalCode four digits {
   *   @requires postalcode only contains 4 digits;
   *   @signals (IllegalArgumentException);
   * }
   */

  @Test (expected=IllegalArgumentException.class)
  public void invalidOnlyFourDigitsPostalCode(){
     // Arrage
     String postalCode = "1982";
     // Act
     boolean result = Validation.checkPostalCode(postalCode);
  }   


}
