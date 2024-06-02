# Homework 2 Quiz & Prompt

## Quiz

### Question 1

Consider inserting the keys 71, 23, 73, 99, 44, 79, 89 into a hash table of size N = 10.
Show the result of hashing using separate chaining if the hash function is h(x) = x mod 10.

**Explainer:**

Enter only buckets containing a value,
with the bucket index followed by a colon,
and then a list of values in that bucket,
separated by spaces.
For example,
the hash table below would be entered as:

0:16

3:11 27 19

6:22 6

![HashTable](HashTable.png)

#### Answer

71 => 1
23 => 3
73 => 3
99 => 9
44 => 4
79 => 9
89 => 9

Thus,

1:71
3:23 73
4:44
9:99 79 89

### Question 2

Now show the results of hashing the same values (71, 23, 73, 99, 44, 79, 89) using linear probing.

#### Answer

71 => 1
23 => 3
73 => 3
99 => 9
44 => 4
79 => 9
89 => 9

Thus,

0:79
1:71
2:89
3:23
4:73
5:44
9:99

### Question 3

Now show the results of hashing the same values (71, 23, 73, 99, 44, 79, 89) using separate chaining and a hash function of h(x) = x mod 5.
Note that the table will still have ten buckets.

#### Answer

71 => 1
23 => 3
73 => 3
99 => 4
44 => 4
79 => 4
89 => 4

Thus,

1:71
3:23 73
4:99 44 79 89


### Question 4

Now show the results of hashing the same values (71, 23, 73, 99, 44, 79, 89) using linear probing and a hash function of h(x) = x mod 5.
Note that the table will still have ten buckets.

#### Answer

71 => 1
23 => 3
73 => 3
99 => 4
44 => 4
79 => 4
89 => 4

Thus,

1:71
3:23
4:73
5:99
6:44
7:79
8:89

## Prompt

In two to three paragraphs of prose (i.e. sentences, not bullet lists) using APA style citations if needed, summarize and interact with the content that was covered in the class session this week. In your summary, you should highlight the major topics, theories, practices, and knowledge that were covered. Your summary should also interact with the material through personal observations, reflections, and applications to the field of study. In particular, highlight what surprised, enlightened, or otherwise engaged you. Make sure to include at least one thing that you’re still confused about. In other words, you should think and write critically not just about what was presented but also what you have learned through the session. You must ask at least one question. If you don't have questions about the material, ask me anything related to computer science, the industry, etc.

### Response

This week's theme was on hashing & collision resolution strategies to create efficient data structures. Specifically, we learned about 3 different ways to utilize hashing to fill in a hash table: linear probing, quadratic probing, and chaining. It's in this type of discussion and brief dive into topics of how these data structures work that made me want to pursue a masters program. In addition to having some formal construct to deep dive into more theory-based matters, I look forward to how these conversations around what goes into the "importable" data structures. That is, taking the time to learn more about alternative strategies to the standard implementations will help me as I continue to develop custom solutions to problems at work.
One thing that was surprising because I never thought about it before was that the map is just a generalization of an array. I figured it was based on something more complicated that an array and a strategy on how to fill the array. This made the O(1) lookup efficiency make more sense (of course assuming a sufficient hashing function to spread the numbers throughout the array).
In your day job, how often do you reach for the strategies and design choices behind standard data structures when designing the data structures for a given problem? That is, do you typically stick with the standard options (`map` in golang, `HashMap` in Java)?
