/*
 * Class StreamConstruction
 * Date 23.01.11
 */

package javaplus.stream.construction;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.OptionalInt;
import java.util.Random;
import java.util.Set;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public class StreamConstruction {

	public static void main(String[] args) throws IOException {
		
		//배열로 생성1
		String[] arr = new String[]{"a", "b", "c"};
		Stream<String> stream1 = Arrays.stream(arr);
		
		//배열로 생성2
		Stream<String> streamOfArrayPart = Arrays.stream(arr, 1, 3);// [b, c]
		
		//Collection 으로 생성
		List<String> list = Arrays.asList("a", "b", "c");
		Stream<String> stream2 = list.stream();
		Stream<String> parallelListStream = list.parallelStream(); //병렬 처리 스트림
		
		//Stream.builder()
		Stream<String> builerStream = 
				Stream.<String>builder()
					.add("a").add("b").add("c")
					.build(); // [a, b, c]
		//Stream.generate()
		Stream<String> generatedStream =
				Stream.generate(() -> "a").limit(5); // [a, a, a, a, a]
		
		//Stream.iterate()
		Stream<Integer> iteratedStream =
				Stream.iterate(10, n -> n * 2).limit(5); // [10, 20, 40, 80. 160]
		
		//기본 타입형 스트림 IntStream, LongStream, DoubleStream
		IntStream intStream = IntStream.range(1, 5); // [1, 2, 3, 4]
		LongStream longStream = LongStream.rangeClosed(1, 5); // [1, 2, 3, 4, 5]
			//기본 타입형의 편리한 메소드들
			intStream.average();
			//intStream.sum();
			//intStream.min();
			//intStream.max();
			
			//위 메소드들은 스트림 자체가 비어있는경우를 대비해 
			//Optional객체로 반환하는데 ifPresent 메소드를 이용해 예외처리를 할 수있다
			//값이 있는경우 ifPresent내 코드가 실행된다.
			longStream.average().ifPresent(t -> System.out.println(t));
		
		//기본 타입형 스트림 박싱하기
		Stream<Integer> boxedIntStream = IntStream.range(1, 5).boxed();
				
		//난수를 이용한 Stream 생성
		DoubleStream doubles = new Random().doubles(3);
		
		//문자열을 이용한 IntStream
		IntStream charsStream = "Stream".chars();// [83, 116, 114, 101, 97, 109]
		
		//정규 표현식 활용
		Stream<String> stringStream =
				Pattern.compile(", ").splitAsStream("a, b, c"); // [a, b, c]
		
		//파일 스트림
		Stream<String> fileStream =
				Files.lines(Paths.get("C:/Users/user/git/JavaStudy/javaplus/stream/construction/file.txt"),Charset.forName("UTF-8"));
		
		//병렬 스트림 생성 _ Fork/Join framework가 내부적으로 사용됨
		Stream<Integer> parallelIntStream = IntStream.range(1, 10).boxed().parallel();
		Stream<Integer> intStream2 = IntStream.range(1, 10).boxed();
		
		//스트림 병렬인지 확인, sequential() 메소드로 다시 일반 스트림으로 바꿀수있음
		parallelIntStream.isParallel();
		
		//병렬 스트림은 순서에 영향을 받는 작업은 잘못 계산될 수 있으니 주의
		int result1 = parallelIntStream.reduce((x, y) -> x - y).get(); //9
		int result2 = intStream2.reduce((x, y) -> x - y).get(); //-43
		
		//두개의 스트림 연결 concat(stream1, stream2);
		Stream<String> stringStream1 = Stream.of("a", "b", "c");
		Stream<String> stringStream2 = Stream.of("d", "e", "f");
		
		Stream<String> concatStream = Stream.concat(stringStream1, stringStream2); 
		
		//Stream<T> filter(Predicate<? super T> predicate)
		Stream<String> unFilteredStream = Stream.of("Idea", "Info", "Slip", "Java", "Work");
		Stream<String> filteredStream = unFilteredStream.filter(str -> str.contains("a")); //[Idea, Java]
		
		//Stream<R> map(Function<? super T, ? extends R> mapper)
		//기본
			Stream<String> unMappedStream = Stream.of("Idea", "Info", "Slip", "Java", "Work");
			Stream<String> mappedStream = unMappedStream.map(String :: toUpperCase);
			
		//클래스 활용
			List<Product> products = new ArrayList<>();
			products.add(new Product("Apple", 1000));
			products.add(new Product("Pear", 2000));
			products.add(new Product("Lime", 1500));
			products.add(new Product("Cola", 1500));
			products.add(new Product("Plastic Bag", 1000));
			products.add(new Product("Coffee", 2500));
			
			IntStream productPriceStream = products.stream().mapToInt(Product :: getPrice);
			Stream<String> productNameStream = products.stream().map(Product::getName).map(String::toUpperCase);
		
		//중첩 제거를 위한 <R> Stream<R> flatMap
		//기본
			List<List<String>> overlaplist = Arrays.asList(Arrays.asList("a"), Arrays.asList("b"));
			List<String> flatList = overlaplist.stream().flatMap(Collection::stream).collect(Collectors.toList()); // [a, b]
		//위에 생성했던 products 활용
			Stream<String> flatproductName = products.stream().flatMap(product -> Stream.<String>builder().add(product.getName() + " : " + product.getPrice()).build());
		
		//정렬 Stream<T> sorted(); , Stream<T> sorted(Comparator<? super T> comparator);
		IntStream.of(14, 11, 20, 39, 23).sorted().forEach(t -> System.out.println(t));
		Stream.of(14, 11, 20, 39, 23).sorted(Comparator.reverseOrder()).forEach(t -> System.out.println(t));
		
		//스트림내 요소로 중간에 작업 확인용 반환하는 스트림이 peek 연산전과 동일함 Stream<T> peak(Consumer<? super T> action)
		IntStream.of(10, 5, 7, 2, 15).sorted().peek(t -> System.out.println(t + 1)).forEach(System.out::println);
	
		//Optional<T> reduce(BinaryOperator<T> accumulator)
		OptionalInt reduced1 = IntStream.range(1, 4).reduce((a, b) -> Integer.sum(a, b));
		
		//T reduce(T indentity, BinaryOperator<T> accumulator)
		int reduced2 = IntStream.range(1, 4).reduce(0, (a, b) -> Integer.sum(a, b));
		
		//<U> U reduce(U identity, BiFunction<U, ? super T, U> accumulator, BinaryOperator<U> combiner);
		
		//아래처럼 작성하면 작동안함 3번째 인자인 combiner는 병렬스트림에서만 작동함
		Integer reduced3 = Stream.of(1, 2, 3)
				.reduce(10, 
				Integer::sum, 
				(a, b) -> {System.out.println("combiner called!");
				return a * b;});
		
		//따라서 병렬 스트림으로 바꾸면 작동함
		reduced3 = Stream.of(1, 2, 3, 4, 5, 6)
				.parallel()
				.reduce(10, 
						Integer::sum, 
						//combiner는 identity와 accmululator의 결과값을 각각 인자로 받아 작동함, 순서가 중요한 작업은 하면 안됨
						(a, b) -> {System.out.println("combiner called!  " + "a : " + a + ", b : " + b);
						return a + b;});
		
		//Collectors.toList() Stream 작업 결과를 List로 반환
		List<String> productNames = products.stream().map(Product::getName).collect(Collectors.toList());
		System.out.println(productNames);
		
		//Collectors.joining() String 작업 결과를 전부 이어 붙여서 String으로 반환
		//joining()
			String joinedproductName1 = products.stream().map(Product::getName).collect(Collectors.joining());
		//joining(delimiter, prefix, suffix)
			String joinedproductName2 = products.stream().map(Product::getName).collect(Collectors.joining(", ", "<",">"));
		
		//Collectors.averageingInt()
			Double avgPrice = products.stream().collect(Collectors.averagingInt(Product::getPrice));
			
		//Collectors.summingInt()
			Integer sumPrice = products.stream().collect(Collectors.summingInt(Product::getPrice));
			//물론 IntStream내 메소드를 이용하려면 다음 처럼도 가능하다
			sumPrice = products.stream().mapToInt(Product::getPrice).sum();
		
		//Collectors.summarizingInt() 한번에 갯수, 합계, 최소 최대값, 평균값 얻을때
			IntSummaryStatistics summarizedPrice = products.stream().collect(Collectors.summarizingInt(Product::getPrice));
			System.out.println(summarizedPrice);
			
		//Collectors.groupingBy() - 특정 값을 기준으로 그룹화
		Map<Integer, List<Product>> collectByPrice = products.stream().collect(Collectors.groupingBy(Product::getPrice));
		collectByPrice.get(1000).forEach(t -> System.out.println(t.getName()));
		
		//Collectors.partitioningBy() - 특정 평가를 통해 true와 false로 그룹화
		Map<Boolean, List<Product>> collectBybool = products.stream().collect(Collectors.groupingBy(n -> n.getName().length() > 5));
		collectBybool.get(false).forEach(t -> System.out.println(t.getName()));
		
		//Collectors.collectingAndThen() - collect 이후 추가 작업이 필요한 경우 사용
		Set<Product> unmodifiableSet = products.stream()
				//Set으로 바꾼다음 수정 불가능한 Set으로 변환
				.collect(Collectors.collectingAndThen(Collectors.toSet(),
													  Collections::unmodifiableSet));
		
		//Collector.of()
		
		
	}
	

}

class Product {
	private String name;
	private int price;
	
	public Product(String name, int price) {
		this.setName(name);
		this.setPrice(price);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}
}
