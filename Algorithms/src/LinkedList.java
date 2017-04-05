
public class LinkedList<E> {

	Item<E> first = null;
	Item<E> last = null;
	int size;

	private static class Item<E> {
		private Item<E> previous;
		private Item<E> next;
		E element;

		Item(Item<E> previous, E element, Item<E> next) {
			this.previous = previous;
			this.element = element;
			this.next = next;

		}

	}

	public void add(E element) {
		Item<E> tempLast = last;
		Item<E> newElement = new Item<>(tempLast, element, null);
		last = newElement;

		if (tempLast == null) {
			first = newElement;
		} else {
			tempLast.next = newElement;
		}
		size++;
	}

	public void addAt(E element, int position) throws Exception {

		if (position < 0 || position > size) {
			throw new IndexOutOfBoundsException("Cannot not Insert as the size is less that the position. Size: " + size
					+ " Position: " + position);
		}

		if (position == size) {
			// Add at last
			Item<E> tempLast = last;
			Item<E> newElement = new Item<>(tempLast, element, null);
			last = newElement;
			if (tempLast == null) {
				first = newElement;
			} else {
				tempLast.next = newElement;
			}
			size++;

		} else {
			// add in between
			Item<E> itemAtPosition = first;

			// Find node at position.
			for (int i = 0; i < position; i++) {
				itemAtPosition = itemAtPosition.next;
			}
			Item<E> previousItem = itemAtPosition.previous;
			Item<E> newElement = new Item<>(previousItem, element, itemAtPosition);
			itemAtPosition.previous = newElement;
			if (previousItem == null) {
				first = newElement;
			} else {
				previousItem.next = newElement;
			}
			size++;

		}

	}

	public void printValues() {
		Item<E> item = first;
		if (item == null) {
			System.out.println("No values to print");
		} else {
			for (int i = 0; i < size; i++) {
				System.out.println(item.element);
				item = item.next;
			}
		}

	}

	public int indexOf(E element) {

		int index = 0;
		Item<E> item = first;
		for (int i = 0; i < size; i++) {
			if (item.element.equals(element)) {
				return index;
			}
			item = item.next;
			index++;
		}
		return -1;

	}

	public boolean remove(E element) {

		Item<E> itemToRemove = first;

		if (size > 0) {
			for (int i = 0; i < size; i++) {
				if (itemToRemove.element.equals(element)) {
					break;
				} else {
					itemToRemove = itemToRemove.next;
				}

			}
			if (!itemToRemove.element.equals(element)) {
				itemToRemove = null;
			}

			if (itemToRemove == null) {
				return false;
			} else {
				Item<E> previous = itemToRemove.previous;
				Item<E> next = itemToRemove.next;

				if (previous == null) {
					next.previous = null;
					first = next;
				} else {
					next.previous = previous;
					itemToRemove.previous = null;
				}

				if (next == null) {
					previous.next = null;
					last = previous;
				} else {
					next.previous = previous;
					itemToRemove.previous = null;
				}

				previous.next = next;

				size--;

			}
		}
		return false;
	}

	public static void main(String... args) throws Exception {

		LinkedList<Integer> list = new LinkedList<>();
		list.add(20);
		list.add(21);
		list.add(22);
		list.add(23);
		list.add(24);
		list.addAt(25, 5);

		list.printValues();
		System.out.println("Index of 20 " + list.indexOf(20));

	}
}
