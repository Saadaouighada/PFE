
import java.sql.Blob;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.sql.rowset.serial.SerialBlob;
import javax.sql.rowset.serial.SerialException;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.linedata.presales.entities.impl.AllocationImpl;
import com.linedata.presales.entities.impl.AuthorisedProductsImpl;
import com.linedata.presales.entities.impl.ConfigEkipImpl;
import com.linedata.presales.entities.impl.ConfiguredListsImpl;
import com.linedata.presales.entities.impl.CurrencyImpl;
import com.linedata.presales.entities.impl.EnvironmentImpl;
import com.linedata.presales.entities.impl.LanguageImpl;
import com.linedata.presales.entities.impl.ListTypesImpl;
import com.linedata.presales.entities.impl.LovDefenitionImpl;
import com.linedata.presales.entities.impl.LovEltImpl;
import com.linedata.presales.entities.impl.ProductsImpl;
import com.linedata.presales.entities.impl.RegionsImpl;
import com.linedata.presales.entities.impl.SelectedServicesImpl;
import com.linedata.presales.entities.impl.ServicesImpl;
import com.linedata.presales.entities.impl.UsersImpl;
import com.linedata.presales.repositories.impl.AllocationRepositoryImpl;
import com.linedata.presales.repositories.impl.AuthorisedProductsRepositoryImpl;
import com.linedata.presales.repositories.impl.ConfigEkipRepositoryImpl;
import com.linedata.presales.repositories.impl.ConfiguredListsRepositoryImpl;
import com.linedata.presales.repositories.impl.CurrencyRepositoryImpl;
import com.linedata.presales.repositories.impl.EnvironmentRepositoryImpl;
import com.linedata.presales.repositories.impl.LanguageRepositoryImpl;
import com.linedata.presales.repositories.impl.ListTypesRepositoryImpl;
import com.linedata.presales.repositories.impl.LovDefenitionIRepositoryImpl;
import com.linedata.presales.repositories.impl.LovEltRepositoryImpl;
import com.linedata.presales.repositories.impl.ProductsRepositoryImpl;
import com.linedata.presales.repositories.impl.RegionsRepositoryImpl;
import com.linedata.presales.repositories.impl.SelectedServicesRepositoryImpl;
import com.linedata.presales.repositories.impl.ServicesRepositoryImpl;
import com.linedata.presales.repositories.impl.UsersRepositoryImpl;

public class Test
{

   public static void main(String[] args) throws SerialException, SQLException
   {
      ClassPathXmlApplicationContext appContext = new ClassPathXmlApplicationContext("spring/test.spring.xml");
      AuthorisedProductsRepositoryImpl authorisedProductsRepository = appContext.getBean("authorisedProductsRepository", AuthorisedProductsRepositoryImpl.class);
      UsersRepositoryImpl usersRepository = appContext.getBean("usersRepository", UsersRepositoryImpl.class);
      ProductsRepositoryImpl productsRepository = appContext.getBean("productsRepository", ProductsRepositoryImpl.class);
      RegionsRepositoryImpl regionsRepository = appContext.getBean("regionsRepository", RegionsRepositoryImpl.class);
      EnvironmentRepositoryImpl environmentRepository = appContext.getBean("environmentRepository", EnvironmentRepositoryImpl.class);
      AllocationRepositoryImpl allocationRepository = appContext.getBean("allocationRepository", AllocationRepositoryImpl.class);
      CurrencyRepositoryImpl currencyRepository = appContext.getBean("currencyRepository", CurrencyRepositoryImpl.class);
      LanguageRepositoryImpl languageRepository = appContext.getBean("languageRepository", LanguageRepositoryImpl.class);
      ConfigEkipRepositoryImpl configEkipRepository = appContext.getBean("configEkipRepository", ConfigEkipRepositoryImpl.class);
      ServicesRepositoryImpl servicesRepository = appContext.getBean("servicesRepository", ServicesRepositoryImpl.class);
      SelectedServicesRepositoryImpl selectedServicesRepository = appContext.getBean("selectedServicesRepository", SelectedServicesRepositoryImpl.class);
      // System.out.println(selectedServicesRepository.getByIdAllocation("1"));
      ConfiguredListsRepositoryImpl configuredListsRepository = appContext.getBean("configuredListsRepository", ConfiguredListsRepositoryImpl.class);
      ListTypesRepositoryImpl listTypesRepository = appContext.getBean("listTypesRepository", ListTypesRepositoryImpl.class);
      AllocationImpl a = allocationRepository.getOne(2);
      a.setCodeStatus("CFG");
      allocationRepository.update(a);
      // Add list type
//      ProductsImpl p = new ProductsImpl(1);
//      ListTypesImpl l1 = new ListTypesImpl(1,"TIERS", "AC", "TIERS", p);
//      System.out.println(listTypesRepository.save(l1));

      // Add configuredLists
//      AllocationImpl a = new AllocationImpl(1);
//      ListTypesImpl l = new ListTypesImpl(2);
//      ConfiguredListsImpl c = new ConfiguredListsImpl(0, "BMW ", "BMW", "BMW ", a, l);
//      System.out.println(configuredListsRepository.save(c));
     // System.out.println(languageRepository.getByCode("ENG"));
      // Selected Services
//      ServicesImpl serv = new ServicesImpl(3);
//      AllocationImpl allo = new AllocationImpl(1);
//      SelectedServicesImpl ss = new SelectedServicesImpl(allo,serv,"S2-"+Long.valueOf(allo.getIdAllocation()));
//      selectedServicesRepository.save(ss);

      // ServicesImpl s = new ServicesImpl(0, "ASSU MATE", "AC", "ASSU MATE",
      // p);
      // servicesRepository.save(s);

      // CurrencyImpl curr = new CurrencyImpl(0, "EUR", "EUR", p);
//      currencyRepository.save(curr);
//      LanguageImpl lang = new LanguageImpl(0, "FR", "FR", p);
//      languageRepository.save(lang);
//      EnvironmentImpl e1 = new EnvironmentImpl(4);
//      UsersImpl u = new UsersImpl(1);
//      RegionsImpl r = new RegionsImpl(1);
//
//      AllocationImpl a = new AllocationImpl(1);
//      byte[] fileId = "Any String you want".getBytes();
//      Blob blob = new SerialBlob(fileId);
//      CurrencyImpl c = new CurrencyImpl(1);
//      LanguageImpl l = new LanguageImpl(1);
//      AllocationImpl allo = new AllocationImpl(4);
//      ConfigEkipImpl conf = new ConfigEkipImpl(0, "CONF4-EKIP", "Toyota", "#FFFFFF", c, l, "$.$", "DD/MM/YY", blob, allo);
//      configEkipRepository.save(conf);
      // java.sql.Date date1= java.sql.Date.valueOf(LocalDate.of(2022, 11, 8));
      // java.sql.Date date2= java.sql.Date.valueOf(LocalDate.of(2023, 02, 01));
      // AllocationImpl a = new AllocationImpl(0,"EKIP-E4-1","Car
      // finance",date1,date2,"CFG","Created for the benefit of the Toyota
      // customer","EKIP","EKIP.360",u,e1,r);
      // System.out.print(environmentRepository.getEnvironmentByCodeStatus("AV"));

      // ProductsImpl prod = productsRepository.getOne(1);
      // RegionsImpl reg = regionsRepository.getOne(1);
      // UsersImpl user = usersRepository.getOne(2);
      // EnvironmentImpl environment = environmentRepository.getOne(3);
      // long millis=System.currentTimeMillis();
      // java.sql.Date date=new java.sql.Date(millis);
      // AllocationImpl allo = new AllocationImpl(1,"A101","Allocation
      // 1",date,date,"AC","allocation pour tester
      // l'ennvironnement","EKIP","EKIP360",user,environment,reg);
      // EnvironmentImpl environment = new EnvironmentImpl(1, "P1E1", prod,

      // "ENV1", "AC", "DB1", "SDB1", "S1", "SD1", "8081", "1521");

      // System.out.print( allocationRepository.getCurrentAllocations());

       byte[] fileId = "Any String you want".getBytes();
       Blob blob = new SerialBlob(fileId);
   //    UsersImpl user = new UsersImpl(1, "US1", "Natalie", "Kjiw", "SA","N.Kjiw@linedata.com", blob, "AN", "AC", prod, reg);
      // ProductsImpl product = productsRepository.getOne(1);
      // AuthorisedProductsImpl a = new AuthorisedProductsImpl(user, product);
      // authorisedProductsRepository.save(a);
      // byte[] fileId = "Any String you want".getBytes();
      // Blob blob = new SerialBlob(fileId);
      // LovDefenitionImpl lov = new LovDefenitionImpl(1);
      // LovEltImpl l = new LovEltImpl(1, "test", "test", "2", 0, "test", lov);
      // List<LovEltImpl> l = new ArrayList();
      // l = lovEltRepository.get("", "L.id = 1");
      // LovEltImpl lov = new LovEltImpl();
      // lov = l.get(0);
      // AuthorisedProductsImpl a = new AuthorisedProductsImpl(1, 1);
      // authorisedProductsRepository.save(a);
      // System.out.println(authorisedProductsRepository.getAll());
      // LovEltLabelImpl x = new LovEltLabelImpl(1,"FR","Français",lov);
      // System.out.println(usersRepository.getAll());
      // System.out.println(lovEltRepository.save(l));
      // Session session = sessionFactory.openSession();
      // Transaction tx = session.beginTransaction();
//      LovDefenitionImpl l = new LovDefenitionImpl(0, "test", "testttttttt");
      // System.out.println(l.getClass().getSimpleName());
      // session.persist(l);

      // tx.commit();
      // session.close();

      /*
       * ClassPathXmlApplicationContext appContext = new
       * ClassPathXmlApplicationContext("spring/mongo/presalesBeans.spring.xml")
       * ; ConfigEkipService configEkipService =
       * appContext.getBean("configEkipService", ConfigEkipService.class);
       * ConfigEkipImpl e = new ConfigEkipImpl("white", "currency", "ENG",
       * "Rawand"); try { InputStream is = new
       * FileInputStream("src/main/resources/user1.png");
       * System.out.println(configEkipService.saveItem(e, is)); } catch
       * (FileNotFoundException e1) { // TODO Auto-generated catch block
       * e1.printStackTrace(); } catch (IOException e1) { // TODO Auto-generated
       * catch block e1.printStackTrace(); }
       */
      /*
       * ClassPathXmlApplicationContext appContext = new
       * ClassPathXmlApplicationContext("spring/mongo/presalesBeans.spring.xml")
       * ; EnvironmentService environmentService =
       * appContext.getBean("environmentService", EnvironmentService.class);
       * Environment e = new EnvironmentImpl("configured", new Date(), new
       * Date(), "Raw", "Ekip30"); e.setId("634802d7b44087fceb76000b");
       * System.out.print(environmentService.updateEnvironment(e));
       * ClassPathXmlApplicationContext appContext = new
       * ClassPathXmlApplicationContext("spring/mongo/presalesBeans.spring.xml")
       * ; EnvironmentService environmentService =
       * appContext.getBean("environmentService", EnvironmentService.class);
       * System.out.print(environmentService.updateAllocationStatus());
       */
   }
}
