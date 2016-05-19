
test that Spring Boot / Spring can use Entities, Repositories defined in other modules, packages

	  <modules>
	  	<module>com.example.springboot.moduleformodel</module>
	  	<module>com.example.springboot.moduleformodel2</module>
	  	<module>com.example.springboot.moduleformodel.accessing-data-jpa</module>
	  </modules>


`com.example.springboot.moduleformodel.accessing-data-jpa` is Spring Boot app module. 

Result `MultiModuleApplication` can even run when `Entity` and `Repository`,
where defined in `com.example.springboot.moduleformodel2` instead of `hello`.
That was unexpected. I think it is still better to specify in `@ComponentScan` at least for documenting purpose.

