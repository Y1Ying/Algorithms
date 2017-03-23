package stack.cat_dog_queue;

/**
 * 实现一种猫狗队列，要求： 1.用户调用add方法将cat类和dog类的实例放到队列中
 * 2.用户可以调用pollAll方法，将队列中所有实例按照进入队列的先后顺序依次弹出
 * 3.用户可以调用pollDog方法，将队列中dog类的实例按照进队列的先后顺序依次弹出
 * 4.用户调用pollCat方法，将队列中cat类的实例按照进队列的先后顺序依次弹出 5.调用isEmpty方法，检查队列中是否还有dog,cat实例
 * 6.isDogEmpty...... 7.isCatEmpty.....
 * 
 * @author dell
 *
 */
public class PetEnterQueue {

	private Pet pet;
	private long count;

	public PetEnterQueue(Pet pet, long count) {
		this.pet = pet;
		this.count = count;
	}

	public Pet getPet() {
		return this.pet;
	}

	public long getCount() {
		return this.count;
	}

	public String getEnterPetType() {
		return this.pet.getPetType();
	}

}
