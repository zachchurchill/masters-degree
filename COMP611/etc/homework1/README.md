# Homework 1 Quiz & Prompt

## Quiz

There are two simple ways to traverse a list:
using an iterator and using indexing and the get() method.
For example the following two methods will produce the same output regardless of the dynamic type of the list passed in as a parameter:

```java
public static <E> void printListOne(List<E> list) {
    for (ListIterator<E> iterator = list.listIterator();
            iterator.hasNext(); ) {
        System.out.println(iterator.next());
    }
} 

public static <E> void printListTwo(List<E> list) {
    for (int i = 0; i < list.size(); ++i) {
        System.out.println(list.get(i));
    }
}
```

Two claims are made:

- printListOne() is more efficient for LinkedList than printListTwo().

- Both algorithms perform the same for ArrayList objects.

Do you think this is true?

**Questions:**
- Enter the O() efficiency of printListOne() using an ArrayList: O(n)
- Enter the O() efficiency of printListOne() using an LinkedList: O(n)
- Enter the O() efficiency of printListTwo() using an ArrayList: O(n)
- Enter the O() efficiency of printListTwo() using an LinkedList: O(n^2)

## Prompt

In two to three paragraphs of prose
(i.e. sentences, not bullet lists)
using APA style citations if needed,
summarize and interact with the content that was covered in the class session this week.
In your summary,
you should highlight the major topics,
theories,
practices,
and knowledge that were covered.
Your summary should also interact with the material through personal observations,
reflections,
and applications to the field of study.
In particular,
highlight what surprised,
enlightened,
or otherwise engaged you.
Make sure to include at least one thing that you’re still confused about.
In other words,
you should think and write critically not just about what was presented but also what you have learned through the session.
You must ask at least one question.
If you don't have questions about the material,
ask me anything related to computer science,
the industry,
etc.

---

This week we reviewed a few topics that I just learned about in COMP 511: adapter design pattern, ArrayList & LinkedList, analyzing straightforward code to derive the big-O efficiency. One topic that was also briefly covered was on sets. Although we mentioned them in COMP 511, it was not a data structure that we went into depth on. It piqued my interest when it was mentioned how most operations involving HashSets are constant time - I look forward to digging into that one!
As of right now I don't feel that anything this week has confused me, though it has given me the chance to go back and read through the textbook. That said, I was surprised when I realized that the DS&A textbook was actually published in 2003 but it goes to show that the fundamentals (and learning them) stand the test of time.
My question: I noticed a project in your background with looping games (above Rey & BB-8) - do you find that side projects away from work has helped to keep you motivated during your career? Do you enjoy using them as ways to excite yourself about programming/to try to use programming in new applications?

