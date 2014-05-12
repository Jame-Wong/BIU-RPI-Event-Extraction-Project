

/* First created by JCasGen Tue Mar 11 18:07:46 IST 2014 */
package eu.excitement.type.temporal;

import org.apache.uima.jcas.JCas; 
import org.apache.uima.jcas.JCasRegistry;
import org.apache.uima.jcas.cas.TOP_Type;



/** This type represents a temporal expression of type Set. For example, every winter,
each Monday, etc. It indicates a recurrence pattern.
 * Updated by JCasGen Tue Mar 11 18:07:46 IST 2014
 * XML source: C:/Java/Git/breep/ace_events/src/main/resources/desc/SpecAnnotator.xml
 * @generated */
public class Set extends TemporalExpression {
  /** @generated
   * @ordered 
   */
  @SuppressWarnings ("hiding")
  public final static int typeIndexID = JCasRegistry.register(Set.class);
  /** @generated
   * @ordered 
   */
  @SuppressWarnings ("hiding")
  public final static int type = typeIndexID;
  /** @generated  */
  @Override
  public              int getTypeIndexID() {return typeIndexID;}
 
  /** Never called.  Disable default constructor
   * @generated */
  protected Set() {/* intentionally empty block */}
    
  /** Internal - constructor used by generator 
   * @generated */
  public Set(int addr, TOP_Type type) {
    super(addr, type);
    readObject();
  }
  
  /** @generated */
  public Set(JCas jcas) {
    super(jcas);
    readObject();   
  } 

  /** @generated */  
  public Set(JCas jcas, int begin, int end) {
    super(jcas);
    setBegin(begin);
    setEnd(end);
    readObject();
  }   

  /** <!-- begin-user-doc -->
    * Write your own initialization here
    * <!-- end-user-doc -->
  @generated modifiable */
  private void readObject() {/*default - does nothing empty block */}
     
}

    