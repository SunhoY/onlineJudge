hash = Hash.new
hash.default = 0

size = Integer(gets)

size.times do
  number = gets.strip

  hash["#{number}"] = hash["#{number}"]+1
end

max = hash.values.max
max_values = hash.select {|key, value| value == max}
min = max_values.min_by { |key, value| key.to_i }

puts "#{min[0]}"