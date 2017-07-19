package lecture8.test.task4;

/**
 * @autor mvl on 19.07.2017.
 */
interface SomeInterface{}
interface SomeInterface2 extends SomeInterface{}
class SomeClass implements SomeInterface2, SomeInterface {}