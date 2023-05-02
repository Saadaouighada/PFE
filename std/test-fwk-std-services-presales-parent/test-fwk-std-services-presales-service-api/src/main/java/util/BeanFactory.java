package util;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
* Dynamic and static bean factory. It is usefull when dealing with 'non
* singleton' beans. Instead of using, in the code:<br>
* <code>BeanClass bean = (BeanClass)Context.getBean(beanName)</code><br>
* it is preferable to
* <ul>
* <li>define a new class <br>
* <code>BeanClassFactory extends BeanFactory<BeanClass>{}</code></li>
* <li>define the new class in the IoC container</li>
* <li>inject the BeanFactory as a dependency</li>
* <li>the bean creation becomes<br>
* <code>BeanClass bean = BeanClassFactory.buildBean()</code><br>
* </li>
* </ul>
* Alternatively, the static method {@link BeanFactory#buildBean(Class)} can be
* used if the interface and implementation respect a basic naming convention.
*/
public class BeanFactory<M>
{

   /** logger. */
   protected static final Log log = LogFactory.getLog(BeanFactory.class);

   /** class to generate */
   private Class<M>           clazz;

   /**
    * Initializes the class to generate.
    * 
    * @param className class name
    * @throws RuntimeException trap for ClassNotFoundException
    */
   @SuppressWarnings(
   { "unchecked" })
   public void setClassName(String className)
   {
      try
      {
         this.clazz = (Class<M>) Class.forName(className);
         // a 'useless bean' is created to check if bean definition is ok.
         buildBean();
      }
      catch (ClassNotFoundException e)
     {
         log.fatal(e, e);
         throw new RuntimeException(e);
      }
   }

   /**
    * Builds a new bean.
    * 
    * @return new object
    * @throws RuntimeException method can catch InstantiationException and
    *            IllegalAccessException
    */
   public M buildBean()
   {
      M obj;
      try
      {
         obj = this.clazz.newInstance();
      }
      catch (InstantiationException e)
      {
         log.fatal(e, e);
         throw new RuntimeException(e);
      }
      catch (IllegalAccessException e)
      {
         log.fatal(e, e);
         throw new RuntimeException(e);
      }
      return obj;
   }

   /**
    * Instantiate an implementation for a given interface if a naming convention
    * is respected: for an interface with a qualified name
    * <code>mypackage.MyEntity</code>, the factory will look for an
    * implementation class named <code>mypackage.impl.MyEntityImpl</code>.<br>
    * If the convention is not respected, an {@link IllegalStateException} will
    * be thrown.
    * 
    * @param <T> Interface class
    * @param interfaceClass class object for our interface
    * @return a new bean instance
    */
   @SuppressWarnings("unchecked")
   public static final <T> T buildBean(Class<T> interfaceClass)
   {
      if (interfaceClass == null)
      {
         throw new IllegalArgumentException("The interface class cannot be null");
      }
      if (!interfaceClass.isInterface())
      {
         throw new IllegalArgumentException("The argument must be an interface");
      }
      final String implClassname = interfaceClass.getPackage().getName() + ".impl." + interfaceClass.getSimpleName() + "Impl";
      try
      {
         Class<?> implClass = Class.forName(implClassname);
        return (T) implClass.newInstance();
      }
      catch (ClassNotFoundException e)
      {
         throw new IllegalStateException("Cannot find implementation for interface " + interfaceClass + ". The name is supposed to be " + implClassname, e);
      }
      catch (InstantiationException e)
      {
         throw new IllegalStateException("Cannot find empty constructor for implementation class " + implClassname, e);
      }
      catch (IllegalAccessException e)
      {
         throw new IllegalStateException("Security error when creating instance of " + implClassname, e);
      }
   }
}
