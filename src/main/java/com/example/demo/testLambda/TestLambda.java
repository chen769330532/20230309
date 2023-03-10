package com.example.demo.testLambda;

public class TestLambda {

	public static void main(String[] args) {
		//自定义接口类,且类中有且仅有一个抽象方法,静态方法和默认方法不算
		Function1 f1 = () -> {
			System.out.println(66666);
			System.out.println(55555);
		};
		f1.add();

		Function2 f2 = s -> System.out.println(s);
		f2.add("5");

		Function3 f3 = Integer -> System.out.println(Integer);
		f3.add(9999999);

		Function4 f4 = FunctionEntity -> System.out.println(FunctionEntity.getName());
		FunctionEntity entity = new FunctionEntity();
		entity.setId("这是我的id");
		entity.setName("这是我的名字");
//		f4.add(entity);

		Function5 f5 = s -> s.getName();
		String add = f5.add(entity);
		System.out.println("Function5:"+add);
		
		Function6 f6 = s -> s;
		String id = f6.add(entity).getId();
		System.out.println("function6:"+id);
		
		Function7 f7 = (a,b) ->{
			a.setName("你妹的");
			a.setId("我妹的");
			return a;
		};
		System.out.println("Function7:"+f7.add(entity, null).toString());
	}
}
